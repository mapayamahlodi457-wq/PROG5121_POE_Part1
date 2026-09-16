package com.poe;

public class Login {
    private User user;

    public Login(User user) {
        this.user = user;
    }

    // Check username: must contain _ and <= 5 chars
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check password: >=8, 1 capital, 1 number, 1 special
    public boolean checkPasswordComplexity(String password) {
        boolean hasCapital = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    // Check cell phone: must start with + and international code
// Regex source: Regex for international phone numbers. Source: https://stackoverflow.com/questions/123559
    public boolean checkCellPhoneNumber(String cell) {
        return cell.matches("\\+\\d{10,15}");
    }

    // Check login credentials
    public boolean loginUser(String username, String password) {
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    // Return login status
    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + user.getUsername() + ", " + user.getLastName() + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Register user with exact messages from brief
    public String registerUser(String username, String password, String cell) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cell)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        user.setUsername(username);
        user.setPassword(password);
        user.setCellPhone(cell);

        return "Username successfully captured. Password successfully captured. Cell number successfully captured.";
    }
}
