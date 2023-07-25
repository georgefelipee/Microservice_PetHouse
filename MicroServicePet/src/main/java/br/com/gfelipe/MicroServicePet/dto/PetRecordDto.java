package br.com.gfelipe.MicroServicePet.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetRecordDto(@NotBlank String nome,@NotNull String raca , Integer dono) {

}
