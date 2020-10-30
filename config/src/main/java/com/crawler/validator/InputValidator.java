package com.crawler.validator;

import com.crawler.exception.InputValidationException;

public class InputValidator {

    public static void validateInput(String[] args) {
        if (args == null) throw new InputValidationException("Arguments should not be null");
        if (args.length < 2) throw new InputValidationException("Arguments should be 2 at least");
        if (args.length > 3) throw new IllegalArgumentException("Arguments should be 3 maximum");
    }

    private InputValidator() {
    }
}
