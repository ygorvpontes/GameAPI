package com.curso.gameapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PlayerRequest(
        @NotBlank @Size(max = 50) String nome,
        @NotNull Integer idGameFav
) {
}