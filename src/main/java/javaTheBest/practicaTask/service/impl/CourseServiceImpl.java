package javaTheBest.practicaTask.service.impl;

import javaTheBest.practicaTask.dao.CourseDao;
import javaTheBest.practicaTask.dao.impl.CourseDaoImpl;
import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao = new CourseDaoImpl();
    @Override
    public String saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public int countOfStudentByCourseId(Long courseId) {
        return  courseDao.countOfStudentByCourseId(courseId);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        courseDao.updateCourse(courseId, newCourse);
        return "Success";
    }

    @Override
    public String deleteCourse(Long courseId) {
        courseDao.deleteCourse(courseId);
        return "SuccessFully Deleted";
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void deleteAllStudentByCourseId(Long courseId) {
        courseDao.deleteAllStudentByCourseId(courseId);

    }

    @Override
    public List<Course> sortCoursesByPriceDesc() {
        return courseDao.sortCoursesByPriceDesc();
    }
}
