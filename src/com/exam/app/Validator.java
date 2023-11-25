package com.exam.app;

import java.time.LocalDate;

public interface Validator {
    public boolean dataIsValid(String input);
    public void printError();
}
