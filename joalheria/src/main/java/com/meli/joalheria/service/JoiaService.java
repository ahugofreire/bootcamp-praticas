package com.meli.joalheria.service;

import com.meli.joalheria.entity.Joia;
import com.meli.joalheria.exception.JoiaNaoEncontradaExcecao;
import com.meli.joalheria.repository.JoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoiaService {
    @Autowired
    private JoiaRepository joiaRepository;

    public Joia findOne(Integer id) {
        Optional<Joia> joia = this.joiaRepository.findById(id);

        return  joia.orElseThrow(() -> new JoiaNaoEncontradaExcecao("Não foi possivel encontra a joia pelo id " + id));
    }

    public Joia save(Joia joia) {

        return  this.joiaRepository.save(joia);

    }

    public List<Joia> find() {
        return this.joiaRepository.findAll();
    }

    public Joia update(Joia joia, Integer id) {
        Optional<Joia> optionalJoia = this.joiaRepository.findById(id);

        if (optionalJoia.isEmpty()) {
            throw  new JoiaNaoEncontradaExcecao("Joia não encontrada para o id " + id);
        }

        optionalJoia.ifPresent(value -> joia.setId(value.getId()));
        this.joiaRepository.save(joia);

        return joia;
    }

    public void delete(Integer id) {
        Optional<Joia> joia = joiaRepository.findById(id);

        joia.ifPresent(value -> this.joiaRepository.deleteById(value.getId()));
    }
}
