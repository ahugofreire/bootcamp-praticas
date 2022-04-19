package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.entity.RealEstate;
import br.com.meli.desafio_quality.entity.Room;
import br.com.meli.desafio_quality.exception.MissingRealEstateException;
import br.com.meli.desafio_quality.repository.RealEstateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RealEstateServiceTest {
    private RealEstateService realEstateService;

    @Mock
    private RealEstateRepository realEstateRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        realEstateService = new RealEstateService();
        realEstateService.setRealEstateRepository(realEstateRepository);
    }
    å
    /**
     * @Author Antonio Hugo
     * */
    @Test
    public void shouldBeAbleToFindARealEstateByName() {
        RealEstate mockRealEstate = new RealEstate("Casa", new District("Jardim 1", BigDecimal.valueOf(500.0)), List.of(new Room(
                "sala", 15.0, 10.0
        )));

        Mockito.when(realEstateRepository.findByName(ArgumentMatchers.any())).thenReturn(mockRealEstate);

        RealEstate result = realEstateService.findByName("Casa");

        assertEquals(mockRealEstate, result);
    }


    @Test
    public void shouldBeAbleToCreateARealEstate() {
        RealEstate mockRealEstate = new RealEstate("Casa", new District("Jardim 1", BigDecimal.valueOf(500.0)), List.of(new Room(
                "sala", 15.0, 10.0
        )));

        Mockito.when(realEstateRepository.save(ArgumentMatchers.any())).thenReturn(mockRealEstate);

        RealEstate result = this.realEstateService.save(mockRealEstate);

        assertThat(result).usingRecursiveComparison().isEqualTo(mockRealEstate);
    }
}
