package codewars.kata.kyu6;

public class ValidPhoneNumber {

    // https://www.codewars.com/kata/525f47c79f2f25a4db000025

    public static boolean validPhoneNumber(String phoneNumber) {

        String regex = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";
        return phoneNumber.matches(regex);
    }
}