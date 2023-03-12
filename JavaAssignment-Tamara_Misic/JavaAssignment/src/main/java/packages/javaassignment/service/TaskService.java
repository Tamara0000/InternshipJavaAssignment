package packages.javaassignment.service;

import packages.javaassignment.entities.Employee;
import packages.javaassignment.entities.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {
    List<Task> findAll();
    Task saveTask(Task task) throws Exception;
    Task updateTask(Task task, int taskId);
    void deleteTask(Integer id);
    List<Task> getPastMonthTasks();
}
