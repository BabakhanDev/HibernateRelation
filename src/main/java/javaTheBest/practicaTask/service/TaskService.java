package javaTheBest.practicaTask.service;

import javaTheBest.practicaTask.entity.Student;
import javaTheBest.practicaTask.entity.Task;

import java.util.List;

public interface TaskService {

    Task getTaskById(Long taskId);

    String updateTask(Long taskId, Task newTask);

    String deleteTask(Long taskId);

    List<Task> getAllTasks();


    //    Drop methods
//    TODO Eger Task'tyn dealine'ny buto elek bolso Task ochup ketpesh kerek
    String deleteTaskByDeadline(Long taskId);
}
