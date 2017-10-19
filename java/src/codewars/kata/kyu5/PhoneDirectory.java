package codewars.kata.kyu5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneDirectory {

    // http://www.codewars.com/kata/56baeae7022c16dd7400086e

    public static String phone(String strng, String num) {

        final String NOT_FOUND = "Error => Not found: ";
        final String TOO_MANY = "Error => Too many people: ";

        if (!strng.contains(num)) {
            return NOT_FOUND + num;
        }

        String number = "+" + num;

        if (strng.indexOf(number) != strng.lastIndexOf(number)) {
            return TOO_MANY + num;
        }

        String contact = getContact(number, strng.split("\n"));

        String regex = "\\+\\d{1,2}-\\d{3}-\\d{3}-\\d{4}";
        String phone = getMatch(regex, contact) + ", ";
        phone = "Phone => " + phone.substring(1);

        contact = contact.replaceFirst(regex, "");

        regex = "<[a-zA-Z'\\s]+>";
        String name = getMatch(regex, contact) + ", ";
        name = buildName(name);

        contact = contact.replaceFirst(regex, "");

        String address = contact.replaceAll("[^\\.\\w\\s-]", "");
        address = buildAddress(address);

        return phone + name + address;
    }

    private static String buildAddress(String address) {
        address = address.replaceAll("_", " ");
        address = address.replaceAll("\\s+", " ");
        return "Address => " + address.trim();
    }

    private static String buildName(String name) {
        name = name.replaceFirst("<", "");
        name = name.replaceFirst(">", "");
        return "Name => " + name;
    }

    private static String getContact(String number, String[] contacts) {

        for (String c : contacts) {
            if (c.contains(number)) {
                return c;
            }
        }

        return null;
    }

    private static String getMatch(String regex, String contact) {
        Matcher matcher = Pattern.compile(regex).matcher(contact);
        matcher.find();
        return matcher.group(0);
    }
}
