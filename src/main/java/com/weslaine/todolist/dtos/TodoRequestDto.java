package com.weslaine.todolist.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoRequestDto(
    @NotBlank(message = "Campo nome não pode estar vazio")
    String name,
    @NotBlank(message = "Campo descrição não pode estar vazio")
    String description,
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Campo de prazo não pode ser nulo")
    LocalDate deadline
) {
    
}
