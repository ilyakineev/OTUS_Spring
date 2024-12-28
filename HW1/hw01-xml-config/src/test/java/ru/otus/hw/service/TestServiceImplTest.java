package ru.otus.hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

import java.util.List;

import static org.mockito.Mockito.*;

class TestServiceImplTest {

    private IOService mockIoService;
    private QuestionDao mockQuestionDao;
    private TestServiceImpl testService;

    @BeforeEach
    void setUp() {
        mockIoService = mock(IOService.class);
        mockQuestionDao = mock(QuestionDao.class);

        testService = new TestServiceImpl(mockIoService, mockQuestionDao);
    }

    @Test
    void testExecuteTest() {
        Answer answer1 = new Answer("Answer 1", true);
        Answer answer2 = new Answer("Answer 2", false);
        Question question1 = new Question("Question 1", List.of(answer1, answer2));

        when(mockQuestionDao.findAll()).thenReturn(List.of(question1));

        testService.executeTest();

        verify(mockIoService).printLine("1 Question 1");
        verify(mockIoService).printFormattedLine("  1 Answer 1");
        verify(mockIoService).printFormattedLine("  2 Answer 2");
    }
}