package com.weslaine.todolist.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weslaine.todolist.dtos.TodoRequestDto;
import com.weslaine.todolist.dtos.TodoResponseDto;
import com.weslaine.todolist.models.TodoEntity;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoResponseDto toDto(TodoEntity todoEntity);
    @Mapping(target = "id", ignore = true)
    TodoEntity toEntity(TodoRequestDto todoRequestDto);
}
