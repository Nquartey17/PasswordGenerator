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

    public static String generatePassword() {
        return null;
    }

    public static void badPassword(String message) {
        System.out.println(message + " Please try again:");
    }


    public static int containsNumber(String password) {
        int count = 0;
        char[] chars = password.toCharArray();
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        return count;
    }

    public static int containsUppercase(String password) {
        int count = 0;
        char[] chars = password.toCharArray();
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }
        return count;
    }

    public static int containsLowercase(String password) {
        int count = 0;
        char[] chars = password.toCharArray();
        for (char ch : chars) {
            if (Character.isLowerCase(ch)) {
                count++;
            }
        }
        return count;
    }

    public static int containsSpecialChar(String password) {
        int count = 0;
        char[] chars = password.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch) && !Character.isUpperCase(ch) &&
            !Character.isLowerCase(ch)) {
                count++;
            }
        }
        return count;
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
                "Password length but be 8 characters or more\n" +
                "Alternatively, you can enter 'generate' for the program to create a random password for you\n");

        System.out.println("Enter your password");
        String password = scnr.nextLine();
        boolean accepted = false;


        //create a method to prevent repetition
        while (!accepted) {
            int uppercase = containsUppercase(password), lowercase = containsLowercase(password),
                    number = containsNumber(password), specialChar = containsSpecialChar(password);

            if (password.equalsIgnoreCase("generate")) {
                System.out.println("Your randomly generated password is ");
                accepted = true;
            }
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