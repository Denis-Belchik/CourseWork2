package pro.sky.CourseWorkCore.service;

import org.junit.jupiter.api.Test;
import pro.sky.CourseWorkCore.model.Question;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void addTestStringPositive() {
        Question actual = javaQuestionService.add("Вопрос 9", "Ответ 9");
        Question expected = new Question("Вопрос 9", "Ответ 9");
        assertEquals(expected, actual);
    }

    @Test
    public void addTestStringNegative() {
        Question actual = javaQuestionService.add("Вопрос 1", "Ответ 1");
        assertNull(actual);
    }

    @Test
    public void addTestQuestionPositive() {
        Question expected = new Question("Вопрос 9", "Ответ 9");
        Question actual = javaQuestionService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void addTestQuestionNegative() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        Question actual = javaQuestionService.add(expected);
        assertNull(actual);
    }

    @Test
    public void removeTestPositive() {
        Question actual = javaQuestionService.remove("Вопрос 1", "Ответ 1");
        Question expected = new Question("Вопрос 1", "Ответ 1");
        assertEquals(expected, actual);
    }

    @Test
    public void removeTestNegative() {
        Question actual = javaQuestionService.remove("Вопрос 9", "Ответ 9");
        assertNull(actual);
    }

    @Test
    public void getAllTestPositive() {
        Collection<Question> actual = javaQuestionService.getAll();

        Collection<Question> expected = new ArrayList<>();
        expected.add(new Question("Вопрос 1", "Ответ 1"));
        expected.add(new Question("Вопрос 2", "Ответ 2"));
        expected.add(new Question("Вопрос 3", "Ответ 3"));
        expected.add(new Question("Вопрос 4", "Ответ 4"));
        expected.add(new Question("Вопрос 5", "Ответ 5"));
        expected.add(new Question("Вопрос 6", "Ответ 6"));
        expected.add(new Question("Вопрос 7", "Ответ 7"));
        expected.add(new Question("Вопрос 8", "Ответ 8"));

        assertIterableEquals(expected, actual);
    }

    @Test
    public void getRandomQuestionTestPositive() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        Question actual = javaQuestionService.getRandomQuestion();
        assertEquals(expected.getClass(), actual.getClass());
    }

}
