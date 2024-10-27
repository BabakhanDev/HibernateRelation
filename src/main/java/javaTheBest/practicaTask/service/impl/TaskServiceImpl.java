package javaTheBest.practicaTask.service.impl;

import javaTheBest.practicaTask.dao.TaskDao;
import javaTheBest.practicaTask.dao.impl.TaskDaoImpl;
import javaTheBest.practicaTask.entity.Task;
import javaTheBest.practicaTask.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao = new TaskDaoImpl();
    @Override
    public Task getTaskById(Long taskId) {
        return taskDao.getTaskById(taskId);
    }

    @Override
    public String updateTask(Long taskId, Task newTask) {
        taskDao.updateTask(taskId, newTask);
        return "Successfully updated";
    }

    @Override
    public String deleteTask(Long taskId) {
        taskDao.deleteTask(taskId);
        return "Successfully deleted";
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public String deleteTaskByDeadline(Long taskId) {
        taskDao.deleteTaskByDeadline(taskId);
        return "Successfully deleted";
    }
}
