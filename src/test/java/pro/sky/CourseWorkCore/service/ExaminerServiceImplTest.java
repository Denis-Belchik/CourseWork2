package pro.sky.CourseWorkCore.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CourseWorkCore.exception.QuestionLimitExceededException;
import pro.sky.CourseWorkCore.model.Question;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getQuestions() {
        Question question = new Question("Вопрос 1", "Ответ 1");
        Collection<Question> expected = new ArrayList<>();
        expected.add(question);

        Mockito.when(questionServiceMock.getRandomQuestion())
                .thenReturn(question);
        Mockito.when(questionServiceMock.getAll())
                .thenReturn(expected);

        Collection<Question> actual = examinerService.getQuestions(1);

        assertIterableEquals(expected, actual);
    }

    @Test
    public void getQuestionsNegative() {
        Question question = new Question("Вопрос 1", "Ответ 1");
        Collection<Question> expected = new ArrayList<>();
        expected.add(question);

        Mockito.when(questionServiceMock.getAll())
                .thenReturn(expected);

        assertThrows(QuestionLimitExceededException.class,
                () -> examinerService.getQuestions(10));
    }

}
