import java.util.*;


public class Main {

    /* I'll try using a scoring system to determine password strength
    0-1 points = Weak
    2-3 points = Medium
    4-6 points = Good
    7+ points = Strong
    ^ Original method won't work, try thinking of something else
     */
    public static void passwordStrength(int numCount, int upCount, int lowCount, int spCount) {
        String text = "Password Strength is ";
        int total = (numCount + upCount + lowCount + spCount) / 4;
        if (total <= 1) {
            System.out.println(text + "weak");
        } else if (total == 2 || total == 3) {
            System.out.println(text + "medium");
        } else if (total == 4 || total == 5 || total == 6) {
            System.out.println(text + "good");
        } else {
            System.out.println(text + "strong");
        }

    }

    /* Method to reduce repetitive code
    takes the number requirements for each character type and adds to hashSet
     */
    public static void addToSet(int count, HashSet<Character> set, char[] array) {
        Random rand = new Random();
        while (count > 0){
            int randomNum = rand.nextInt(array.length);
            set.add(array[randomNum]);
            count--;
        }

    }

    /* Password length will always be 14 characters
    contains 3 numbers, 3 special characters, 3 uppercase letters, and 5 lowercase
    characters will be randomly scrambled, no duplicates
    I've noticed sometimes the password length is < 14, Still trying to figure out why that happens
     */
    public static String generatePassword() {
        HashSet<Character> charSet = new HashSet<>();
        char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUpper = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        char[] nums = "0123456789".toCharArray();
        char[] spChars = "!@#$%^&*()[]{}<>.".toCharArray();

        //add numbers to the set
        int numCount = 3;
        addToSet(numCount, charSet, nums);

        //add lowercase letters to set
        int lowerChars = 5;
        addToSet(lowerChars, charSet, alphabetLower);

        //add uppercase letters to set
        int upperChars = 3;
        addToSet(upperChars, charSet, alphabetUpper);

        //add special characters to set
        int specialChars = 3;
        addToSet(specialChars, charSet, spChars);

        //randomize elements in arraylist
        List<Character> passwordChars = new ArrayList<>(charSet);
        Collections.shuffle(passwordChars);

        StringBuilder sb = new StringBuilder();
        for (Character value : passwordChars) {
            sb.append(value.toString());
        }
        return sb.toString();
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
                "Password length must be 8 characters or more\n" +
                "Alternatively, you can enter 'generate' for the program to create a random password for you\n");

        System.out.println("Enter your password");
        String password = scnr.nextLine();
        boolean accepted = false;


        //create a method to prevent repetition
        while (!accepted) {
            int uppercase = containsUppercase(password), lowercase = containsLowercase(password),
                    number = containsNumber(password), specialChar = containsSpecialChar(password);

            if (password.equalsIgnoreCase("generate")) {
                System.out.println("Your randomly generated password is " + generatePassword());
                accepted = true;
            }
            else if (password.length() < 8) {
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