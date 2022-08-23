package org.example.validator;


import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailValidatorTest  {

    private EmailValidator emailValidator;

    @BeforeEach
    public void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    public void validateEmailIdValidEmailId() throws EmailValidator {

        boolean actualEmail=emailValidator.validateEmailId("Pratham@infy.com");
        boolean expectedValue=false;
        assertEquals(actualEmail,expectedValue);
    }

    @Test
    public void validateEmailIdInvalidEmailId() throws EmailValidator {
        boolean actualEmail=emailValidator.validateEmailId("james_potteer@infy.org");
        boolean expectedValue=false;
        assertEquals(actualEmail,expectedValue);
    }

    @Test
    public void validateEmailIdInvalidEmailIdException() throws EmailValidator {
        assertThrows(EmailValidator.class,
                ()->{

                    boolean actualEmail=emailValidator.validateEmailId(null);
                });

    }

    @ParameterizedTest
    @ValueSource(strings = { "Tom_Holand","Thomes_aandre@Hog.in","Mark_eddi","honda.com" })
    public void validateEmailIdParamterizedEmailId(String abc) throws EmailValidator {
        assertNotNull(abc);
    }

    @AfterEach
    public void teardown() {
        emailValidator = null;
    }

}