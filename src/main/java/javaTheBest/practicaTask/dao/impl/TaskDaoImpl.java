package javaTheBest.practicaTask.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import javaTheBest.practicaTask.config.DatabaseConnection;
import javaTheBest.practicaTask.dao.TaskDao;
import javaTheBest.practicaTask.entity.Task;

import java.time.LocalDate;
import java.util.List;

public class TaskDaoImpl implements TaskDao {
    EntityManagerFactory em = DatabaseConnection.getEntityManager();
    @Override
    public Task getTaskById(Long taskId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, taskId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task;
    }

    @Override
    public String updateTask(Long taskId, Task newTask) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, taskId);
        task.setDeadline(newTask.getDeadline());
        task.setDescription(newTask.getDescription());
        return "Successfully updated";
    }

    @Override
    public String deleteTask(Long taskId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, taskId);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted";
    }

    @Override
    public List<Task> getAllTasks() {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        List<Task> tasks = entityManager.createQuery("from Task").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @Override
    public String deleteTaskByDeadline(Long taskId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Task task = entityManager.find(Task.class, taskId);

            if (task != null) {
                if (task.getDeadline().isBefore(LocalDate.now())) {
                    entityManager.remove(task);
                    entityManager.getTransaction().commit();
                    return "Task successfully deleted as the deadline has passed.";
                } else {
                    entityManager.getTransaction().rollback();
                    return "Cannot delete task: the deadline has not passed yet.";
                }
            } else {
                entityManager.getTransaction().rollback();
                return "Task not found.";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return "Failed to delete task.";
        } finally {
            entityManager.close();
        }
    }

}

