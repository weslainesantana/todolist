package com.weslaine.todolist.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weslaine.todolist.dtos.TodoRequestDto;
import com.weslaine.todolist.dtos.TodoResponseDto;
import com.weslaine.todolist.services.TodoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @PostMapping 
    public TodoResponseDto createTodo(@RequestBody @Valid TodoRequestDto todoRequestDto) {
        return todoService.createTodo(todoRequestDto);
    }

    @GetMapping 
    public Page<TodoResponseDto> getPage(Pageable pageable) {
        return todoService.getPage(pageable);
    }

    @GetMapping("/{id}")
    public TodoResponseDto getById(@PathVariable Long id) {
        return todoService.getById(id);
    }
    
    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody @Valid TodoRequestDto todoRequestDto){
        return todoService.updateTodo(id, todoRequestDto);
    }

    @DeleteMapping("/{id}")
    public TodoResponseDto deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }
}
