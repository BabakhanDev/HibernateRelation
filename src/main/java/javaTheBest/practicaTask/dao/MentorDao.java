package javaTheBest.practicaTask.dao;

import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.entity.Lesson;
import javaTheBest.practicaTask.entity.Mentor;
import javaTheBest.practicaTask.entity.Student;

import java.util.List;
import java.util.Map;

public interface MentorDao {
    // TODO Crud
    Mentor getMentorById(Long mentorId);


    String updateMentor(Long mentorId, Mentor newMentor);

    String deleteMentor(Long mentorId);

    List<Mentor> getAllMentors();

    Map<Lesson, List<Student>> getAllLessonAndStudentByMentor   (String nameMentor);
}
