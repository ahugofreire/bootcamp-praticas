package br.com.meli.desafio_quality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.List;


/**
 * @author Marcelo Leite, Ana preis
 * criação da entidade,   validação dos atributos da entidade real estate
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealEstate {

  @NotBlank(message = "O nome da propriedade não pode ficar vazio.")
  @Pattern(regexp = "([A-Z])[\\s|[0-9]|A-Z|a-záàâãéèêíïóôõöúçñ]*", message = "O nome da propriedade deve começar com letra maiúscula.")
  @Size(max = 30, message = "O comprimento do nome da propriedade não pode exceder 30 caracteres.")
  private String propName;

  private District district;
  private List<@Valid Room> rooms;

}
