package javaTheBest.practicaTask.service.impl;

import javaTheBest.practicaTask.dao.CourseDao;
import javaTheBest.practicaTask.dao.CourseDaoImpl;
import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.service.CourseService;

public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao = new CourseDaoImpl();
    @Override
    public String saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }
}
