package org.example.validator;

import junit.framework.TestCase;
import org.example.exception.InvalidPasswordException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

    private static PasswordValidator p;

    @BeforeClass
    public static void setUp() {
        p = new PasswordValidator();
    }

    @Test
    public void validatePasswordValidPassword() throws InvalidPasswordException {
        boolean actualPass = p.validatePassword("Asdf123");
        boolean expectedPass = false;
        assertEquals(actualPass, expectedPass);
    }

    @Test
    public void validatePasswordInvalidPassword() throws InvalidPasswordException {
        boolean actualPass = p.validatePassword("Asdf");
        boolean expectedPass = false;
        assertEquals(actualPass, expectedPass);
    }

    @Test
    public void validatePasswordInvalidPasswordException() throws InvalidPasswordException {
        assertThrows(InvalidPasswordException.class,
                ()->{
                    p.validatePassword(null);
                });

    }

    @ParameterizedTest
    @ValueSource(strings = { "Qwerty","Qwerty1234","Qwertyxdfgsdfdsfdsf","zxcv12365" })
    public void validatePasswordParameterizedPassword(String abc) throws InvalidPasswordException {
        assertNotNull(abc);
    }

    @AfterClass
    public static void teardown() {
        p = null;
    }


}