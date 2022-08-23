package org.example.validator;

import org.example.exception.InvalidEmailException;

public class EmailValidator extends Throwable {

    public boolean validateEmailId(String emailId){

        if(emailId == null || emailId.isEmpty())
            throw new InvalidEmailException("Invalid Email ID");
        return emailId.matches("\\w+@\\w\\.(com|in)");
    }
}
