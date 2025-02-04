package com.weslaine.todolist.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TodoResponseDto(
    Long id,
    String name, 
    String description,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate deadline
) {
    
}
