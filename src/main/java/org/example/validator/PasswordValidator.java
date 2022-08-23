package org.example.validator;

import org.example.exception.InvalidPasswordException;

public class PasswordValidator {

    public boolean validatePassword(String password)  {
        if(password == null || password.isEmpty())
            throw new InvalidPasswordException("Invalid Password.");
        return password.matches("[A-Za-z0-9]{8,20}");
    }
}
