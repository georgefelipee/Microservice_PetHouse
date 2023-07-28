package br.com.gfelipe.MicroServicePet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record PetRecordDto(@NotBlank String nome,@NotNull String raca , Integer dono) {

}
