package com.weslaine.todolist.services;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.weslaine.todolist.dtos.TodoRequestDto;
import com.weslaine.todolist.dtos.TodoResponseDto;
import com.weslaine.todolist.mappers.TodoMapper;
import com.weslaine.todolist.models.TodoEntity;
import com.weslaine.todolist.repositories.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoResponseDto createTodo(TodoRequestDto todoRequestDto) {
        return todoMapper.toDto(todoRepository.save(todoMapper.toEntity(todoRequestDto)));
    }

    public Page<TodoResponseDto> getPage(Pageable pageable) {
        Page<TodoEntity> todo = todoRepository.findAll(pageable);
        return todo.map(todoMapper::toDto);
    }

    public TodoResponseDto getById(Long id) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Tarefa não encontrada");
        return todoMapper.toDto(todo.get());
    } 
    
    public TodoResponseDto updateTodo(Long id, TodoRequestDto todoRequestDto){
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        TodoEntity todoEntity = todoMapper.toEntity(todoRequestDto);
        todoEntity.setId(id);
        return todoMapper.toDto(todoRepository.save(todoEntity));
    }

    public TodoResponseDto deleteTodo(Long id) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        todoRepository.delete(todo.get());
        return todoMapper.toDto(todo.get());
    }
}
