package ru.otus.hw.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionReadExceptionTest {

    @Test
    void testConstructorWithMessage() {
        String errorMessage = "Error reading question";

        QuestionReadException exception = new QuestionReadException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String errorMessage = "Error reading question";
        Throwable cause = new RuntimeException("Root cause");

        QuestionReadException exception = new QuestionReadException(errorMessage, cause);

        assertEquals(errorMessage, exception.getMessage());

        assertEquals(cause, exception.getCause());
    }
}