package ru.otus.hw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StreamsIOServiceTest {

    private PrintStream mockPrintStream;
    private StreamsIOService ioService;

    @BeforeEach
    void setUp() {
        mockPrintStream = mock(PrintStream.class);
        ioService = new StreamsIOService(mockPrintStream);
    }

    @Test
    void testPrintLine() {
        String message = "Hello, World!";
        ioService.printLine(message);

        verify(mockPrintStream).println(message);
    }

    @Test
    void testPrintFormattedLine() {
        String message = "Hello, %s!";
        String name = "John";
        ioService.printFormattedLine(message, name);

        verify(mockPrintStream).printf(message + "%n", name);
    }
}