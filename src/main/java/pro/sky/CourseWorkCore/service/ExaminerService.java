package pro.sky.CourseWorkCore.service;

import pro.sky.CourseWorkCore.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
