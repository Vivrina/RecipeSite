package ru.itis.filters;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class SignInFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
