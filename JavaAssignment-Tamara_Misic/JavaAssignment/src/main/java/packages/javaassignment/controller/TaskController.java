package packages.javaassignment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import packages.javaassignment.entities.Task;
import packages.javaassignment.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task) throws Exception {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Integer taskId){
        return ResponseEntity.ok(taskService.updateTask(task, taskId));
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Integer taskId){
        taskService.deleteTask(taskId);
    }
}
