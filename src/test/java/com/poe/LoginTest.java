package com.poe;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    // assertEquals tests from Number 4
    @Test
    public void testUsernameCorrectlyFormatted() {
        User user = new User("kyle", "Dube", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        String result = login.returnLoginStatus(true);
        assertEquals("Welcome kyl_1, Dube it is great to see you.", result);
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        User user = new User("kyle!!!!!!!", "Dube", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        boolean result = login.checkUserName(user.getUsername());
        assertFalse(result);
    }

    @Test
    public void testPasswordMeetsComplexity() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        String result = login.registerUser(user.getUsername(), user.getPassword(), user.getCellPhone());
        assertTrue(result.contains("Password successfully captured"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        User user = new User("kyl_1", "Dube", "kyl_1", "password", "+27838968976");
        Login login = new Login(user);
        String result = login.registerUser(user.getUsername(), user.getPassword(), user.getCellPhone());
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        String result = login.registerUser(user.getUsername(), user.getPassword(), user.getCellPhone());
        assertTrue(result.contains("Cell number successfully captured"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "08966553");
        Login login = new Login(user);
        String result = login.registerUser(user.getUsername(), user.getPassword(), user.getCellPhone());
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.", result);
    }

    // assertTrue/False tests from Number 4
    @Test
    public void testLoginSuccessful() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        boolean result = login.loginUser("kyl_1", "wrong");
        assertFalse(result);
    }

    @Test
    public void testUsernameCorrectlyFormattedBool() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        boolean result = login.checkUserName(user.getUsername());
        assertTrue(result);
    }

    @Test
    public void testUsernameIncorrectlyFormattedBool() {
        User user = new User("kyle", "Dube", "kyle", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        boolean result = login.checkUserName(user.getUsername());
        assertFalse(result);
    }

    @Test
    public void testPasswordComplexityBoolTrue() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        boolean result = login.checkPasswordComplexity(user.getPassword());
        assertTrue(result);
    }

    @Test
    public void testPasswordComplexityBoolFalse() {
        User user = new User("kyl_1", "Dube", "kyl_1", "password", "+27838968976");
        Login login = new Login(user);
        boolean result = login.checkPasswordComplexity(user.getPassword());
        assertFalse(result);
    }

    @Test
    public void testCellPhoneBoolTrue() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login login = new Login(user);
        boolean result = login.checkCellPhoneNumber(user.getCellPhone());
        assertTrue(result);
    }

    @Test
    public void testCellPhoneBoolFalse() {
        User user = new User("kyl_1", "Dube", "kyl_1", "Ch&&sec@ke99!", "08966553");
        Login login = new Login(user);
        boolean result = login.checkCellPhoneNumber(user.getCellPhone());
        assertFalse(result);
    }
}