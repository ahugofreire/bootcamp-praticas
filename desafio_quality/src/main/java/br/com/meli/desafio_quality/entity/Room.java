package br.com.meli.desafio_quality.entity;

import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Juliio Gama, Felipe Myose
 * criação da entidade, validação dos atributos da entidade real estate
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @NotBlank(message = "O nome do cômodo não pode estar vazio.")
    @Pattern(regexp="([A-Z])[\\s|[0-9]|A-Z|a-záàâãéèêíïóôõöúçñ]*", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O nome do cômodo não pode excder 30 caracteres.")
    private String roomName;
    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @DecimalMax(value = "25.0", message = "A largura máxima permitida por cômodo é de 25 metros.")
    private Double roomWidth;
    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @DecimalMax(value = "33.0", message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double roomLength;
}
