package com.weslaine.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weslaine.todolist.models.TodoEntity;

public interface TodoRepository extends JpaRepository< TodoEntity, Long>{
    
}
