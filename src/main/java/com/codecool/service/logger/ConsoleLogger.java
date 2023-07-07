package com.codecool.service.logger;

import java.time.LocalDateTime;

import static java.lang.System.*;

public class ConsoleLogger implements Logger {
    @Override
    public void logInfo(String message) {
        out.println(formatLogEntry("INFO", message));
    }

    @Override
    public void logError(String message) {
        err.println(formatLogEntry("ERROR", message));
    }

    private String formatLogEntry(String type, String message) {
        LocalDateTime timpstamp = LocalDateTime.now();
        return String.format("[%s] %s: %s", timpstamp, type, message);
    }
}
