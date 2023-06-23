package pro.sky.CourseWorkCore.service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWorkCore.exception.QuestionLimitExceededException;
import pro.sky.CourseWorkCore.model.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    private final Collection<Question> randQuestions = new HashSet<>();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size())
            throw new QuestionLimitExceededException();
        while (randQuestions.size() < amount) {
            randQuestions.add(questionService.getRandomQuestion());
        }
        return Collections.unmodifiableCollection(randQuestions);
    }

}
