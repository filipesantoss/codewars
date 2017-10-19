package codewars.kata.kyu5;

import codewars.kata.utils.Binary;

public class Int32ToIPv4 {

    // https://www.codewars.com/kata/52e88b39ffb6ac53a400022e

    public static String longToIP(long ip) {
        String binary = getBinary(ip);
        return getIp(binary);
    }

    private static String getIp(String binary) {

        String[] octets = binary.split("\\.");

        for (int i = 0; i < octets.length; i++) {
            octets[i] = getDecimal(octets[i]);
        }

        return String.join(".", octets);
    }

    private static String getDecimal(String octet) {
        int decimal = Integer.parseInt(octet, 2);
        return Integer.toString(decimal);
    }

    private static String getBinary(long ip) {
        long[] bits = Binary.getBits(ip, 32);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bits.length; i++) {

            if (i > 0 && i % 8 == 0) {
                sb.append(".");
            }

            sb.append(bits[i]);
        }

        return sb.toString();
    }
}
