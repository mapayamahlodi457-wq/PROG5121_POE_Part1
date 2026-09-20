package com.poe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("First Name: ");
        String first = sc.nextLine();
        System.out.print("Last Name: ");
        String last = sc.nextLine();
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Cell (e.g. +27838968976): ");
        String cell = sc.nextLine();

        // Create User - your User needs 5 things
        User user = new User(first, last, username, password, cell);
        Login login = new Login(user);

        // Register - this will show if username/password/cell is correct
        String regResult = login.registerUser(username, password, cell);
        System.out.println(regResult);

        System.out.println("\n--- LOGIN ---");
        System.out.print("Username: ");
        String lu = sc.nextLine();
        System.out.print("Password: ");
        String lp = sc.nextLine();

        boolean isLoggedIn = login.loginUser(lu, lp);
        String loginMessage = login.returnLoginStatus(isLoggedIn);
        System.out.println(loginMessage);
    }
}