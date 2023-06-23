package pro.sky.CourseWorkCore.service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWorkCore.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    public JavaQuestionService() {
        questions.add(new Question("Вопрос 1", "Ответ 1"));
        questions.add(new Question("Вопрос 2", "Ответ 2"));
        questions.add(new Question("Вопрос 3", "Ответ 3"));
        questions.add(new Question("Вопрос 4", "Ответ 4"));
        questions.add(new Question("Вопрос 5", "Ответ 5"));
        questions.add(new Question("Вопрос 6", "Ответ 6"));
        questions.add(new Question("Вопрос 7", "Ответ 7"));
        questions.add(new Question("Вопрос 8", "Ответ 8"));
    }

    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        if (questions.add(questionNew)) {
            return questionNew;
        }
        return null;
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionNew = new Question(question, answer);
        if (questions.remove(questionNew))
            return questionNew;
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(random.nextInt(0, questionList.size()));
    }

}
