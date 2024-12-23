package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.hw.dao.QuestionDao;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public void executeTest() {
        AtomicInteger i = new AtomicInteger();
        questionDao.findAll().forEach(question -> {
            i.getAndIncrement();
            ioService.printLine(i + " " + question.text());
            AtomicInteger j = new AtomicInteger();
            question.answers().forEach(answer -> {
                j.getAndIncrement();
                ioService.printFormattedLine("  " + j + " " + answer.text());
            });

        });
    }
}
