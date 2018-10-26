package test;

import Controller.Validation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    public void NewPasswordOk(){

        String newPassword = "ytrezA321!";

        assertTrue(Validation.validatePassword(newPassword), "password ok");

    }

    @Test
    public void passwordToLong() {

        String newPassword = "AZertyui1234!!azert";

        assertFalse(Validation.validatePassword(newPassword), "password Without number");

    }

    @Test
    public void passwordWithoutNumber(){

        String newPassword = "ytrezA!";

        assertFalse(Validation.validatePassword(newPassword), "password Without number");
    }

    @Test
    public void passwordWithoutChar(){

        String newPassword = "123!";

        assertFalse(Validation.validatePassword(newPassword), "password Without char");

    }

    @Test
    public void passwordWithoutSpecial(){

        String newPassword = "Ytreza123";

        assertFalse(Validation.validatePassword(newPassword), "password without special");

    }

    @Test
    public void passwordWithoutMaj(){

        String newPassword = "ytreza123!";

        assertFalse(Validation.validatePassword(newPassword), "password without Maj");

    }

    @Test
    public void passwordWithAccent() {

        String newPassword = "ytréza123!";
        assertFalse(Validation.validatePassword(newPassword), "password with accent");
    }

    @Test
    public void wrongNewPassword(){

        String newPassword = "rorogar";

        assertFalse(Validation.validatePassword(newPassword), "Invalid password");

    }

}