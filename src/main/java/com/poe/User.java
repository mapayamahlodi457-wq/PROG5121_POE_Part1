package com.poe;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhone;

    // Constructor - ADD firstName here
    public User(String firstName, String lastName, String username, String password, String cellPhone) {
        this.firstName = firstName;  //
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
    }

    // Getters so Login class can use them
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getCellPhone() { return cellPhone; }

    // Setters so Login can save the user
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setCellPhone(String cellPhone) { this.cellPhone = cellPhone; }

}
