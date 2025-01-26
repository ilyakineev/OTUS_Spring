package ru.otus.hw;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.service.TestRunnerService;

@ShellComponent
@AllArgsConstructor
public class ApplicationShell {
        private final TestRunnerService testRunnerService;

        @ShellMethod(key = "start")
        public void runTest() {
                testRunnerService.run();
        }
}
