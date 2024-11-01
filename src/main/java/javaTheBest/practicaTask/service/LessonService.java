package javaTheBest.practicaTask.service;

import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.entity.Lesson;

import java.util.List;

public interface LessonService {


    Lesson getLessonById(Long lessonId);

    String updateLesson(Long lessonId, Lesson newLesson);

    String deleteLesson(Long lessonId);

    List<Lesson> getAllLessons();


    //    Dop methods
    String deleteLessonByCourseId(Long courseId,Long lessonId);
    List<Lesson> sortLessonByPublishedDate();
}
