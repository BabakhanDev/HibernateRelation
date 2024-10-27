package javaTheBest.practicaTask.service.impl;

import javaTheBest.practicaTask.dao.MentorDao;
import javaTheBest.practicaTask.dao.impl.MentorDaoImpl;
import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.entity.Lesson;
import javaTheBest.practicaTask.entity.Mentor;
import javaTheBest.practicaTask.entity.Student;
import javaTheBest.practicaTask.service.MentorService;

import java.util.List;
import java.util.Map;

public class MentorServiceImpl implements MentorService {
    private final MentorDao mentorDao = new MentorDaoImpl();

    @Override
    public Mentor getMentorById(Long mentorId) {
        return mentorDao.getMentorById(mentorId);
    }

    @Override
    public String updateMentor(Long mentorId, Mentor newMentor) {
        mentorDao.updateMentor(mentorId, newMentor);
        return "Successfully updated mentor";
    }

    @Override
    public String deleteMentor(Long mentorId) {
        mentorDao.deleteMentor(mentorId);
        return "Successfully deleted mentor";
    }

    @Override
    public List<Mentor> getAllMentors() {
        return mentorDao.getAllMentors();
    }

    @Override
    public Map<Lesson, List<Student>> getAllLessonAndStudentByMentor(String nameMentor) {
        return mentorDao.getAllLessonAndStudentByMentor(nameMentor);
    }
}
