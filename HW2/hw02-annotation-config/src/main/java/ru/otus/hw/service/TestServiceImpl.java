package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Student;
import ru.otus.hw.domain.TestResult;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Service
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        for (var question: questions) {
            ioService.printLine(question.text());
            AtomicInteger j = new AtomicInteger();
            question.answers().forEach(a -> {
                ioService.printLine("  " + j + " " + a.text());
                j.getAndIncrement();
            });
            var answer = ioService.readIntForRange(0, question.answers().size(), "There is no such answer, please try again.");
            var isAnswerValid = question.answers().get(answer).isCorrect();
            testResult.applyAnswer(question, isAnswerValid);
        }
        return testResult;
    }
}
