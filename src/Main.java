import java.util.*;


public class Main {

    /* I'll try using a scoring system to determine password strength
    0 points = Weak
    1-2 points = Medium
    3-5 points = Good
    6+ points = Strong
     */
    public static void passwordStrength(String password) {

    }

    public static void badPassword(String message) {
        System.out.println(message + " Please try again");
    }

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
        int uppercase = 0, lowercase = 0, number = 0, specialChar = 0;

        //Check every character in string and add to values for requirements are met
        //Remember to reset values after each failure
        for (int i = 0; i < password.length(); i++) {
            char letter = password.charAt(i);
            if (Character.isDigit(letter)) {
                number++;
            } else if (Character.isUpperCase(letter)) {
                uppercase++;
            } else if (Character.isLowerCase(letter)) {
                lowercase++;
            } else {
                specialChar++;
            }
        }

        //create a method to prevent repetition
        while (!accepted) {
            if (password.length() < 8) {
                badPassword("Password length is too short.");
                password = scnr.nextLine();
            } else if (number < 1) {
                badPassword("Password must contain numeric value.");
                password = scnr.nextLine();
            } else if (uppercase < 1) {
                badPassword("Password must contain uppercase letter.");
                password = scnr.nextLine();
            } else if (lowercase < 1) {
                badPassword("Password must contain lowercase letter.");
                password = scnr.nextLine();
            } else if (specialChar < 1) {
                badPassword("Password must contain special character.");
                password = scnr.nextLine();
            } else {
                System.out.println("Password accepted!");
                accepted = true;
            }
        }

    }




}