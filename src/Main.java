import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to the password generator program");
        System.out.println("Enter a password and the program will determine the strength of the password\n\n" +
                "Password requirements: \n" +
                "At least 1 uppercase letter\n" +
                "At least 1 lowercase letter\n" +
                "At least 1 number\n" +
                "At least 1 special character\n" +
                "Password length but be 8 characters or more\n");

        System.out.println("Enter your password");
        String password = scnr.nextLine();
        boolean accepted = false;

        if (password.length() < 8) {
            System.out.println("Password length is too short. Please try again");
        }
    }
}