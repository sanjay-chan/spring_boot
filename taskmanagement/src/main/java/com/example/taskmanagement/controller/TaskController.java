package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/insert")
    public ResponseEntity<Task> insertTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok(savedTask);
    }
}

// ssss
// CREATE DATABASE taskdb;
// CREATE USER 'taskuser'@'localhost' IDENTIFIED BY 'password';
// GRANT ALL PRIVILEGES ON taskdb.* TO 'taskuser'@'localhost';
// FLUSH PRIVILEGES;
