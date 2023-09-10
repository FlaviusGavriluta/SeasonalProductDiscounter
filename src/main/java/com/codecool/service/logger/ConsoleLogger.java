package com.codecool.service.logger;

import java.time.LocalDateTime;

import static java.lang.System.out;

public class ConsoleLogger implements Logger {
    @Override
    public void logInfo(String message) {
        out.println(createLogEntry("INFO", message));
    }

    @Override
    public void logError(String message) {
        out.println(createLogEntry("ERROR", message));
    }

    private String createLogEntry(String type, String message) {
        return String.format("[%s] %s: %s", LocalDateTime.now(), type, message);
    }
}