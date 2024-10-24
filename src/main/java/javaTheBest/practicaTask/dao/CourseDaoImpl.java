package javaTheBest.practicaTask.dao;

import jakarta.persistence.EntityManager;
import javaTheBest.practicaTask.config.DatabaseConnection;
import javaTheBest.practicaTask.entity.Course;

public class CourseDaoImpl implements CourseDao {
//EntityManager em = DatabaseConnection.getSessionFactory();
    @Override
    public String saveCourse(Course course) {
        return "";
    }
}
