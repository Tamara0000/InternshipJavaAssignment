package packages.javaassignment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import packages.javaassignment.entities.Employee;
import packages.javaassignment.entities.Task;
import packages.javaassignment.repository.TaskRepository;
import packages.javaassignment.service.TaskService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) throws Exception {
        Task task1 = taskRepository.findByTitle(task.getTitle());
        if(task1 == null){
            //This task doesn't exist yet in db
            return taskRepository.save(task);
        }else {
            //Duplicate
            throw new Exception("Task with that title already exists in db!");
        }
    }

    @Override
    public Task updateTask(Task task, int taskId) {
        Task taskUpdate = taskRepository.findById(taskId).get();
        taskUpdate.setAssignee(task.getAssignee());
        taskUpdate.setDescription(task.getDescription());
        taskUpdate.setDueDate(task.getDueDate());
        return taskRepository.save(taskUpdate);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getPastMonthTasks() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) - 1;//current month - 1
        return taskRepository.findAllByDueDate(month);
    }
}