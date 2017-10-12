package codewars.kata.kyu6;

public class SimpleEncryption1AlternatingSplit {

    /**
     * For building the encrypted string:
     * Take every 2nd char from the string, then the other chars, that are not every 2nd char, and concat them as new String.
     * Do this n times!
     * <p>
     * Examples:
     * <p>
     * "This is a test!", 1 -> "hsi  etTi sats!"
     * "This is a test!", 2 -> "hsi  etTi sats!" -> "s eT ashi tist!"
     * Write two methods:
     * <p>
     * String encrypt(final String text, final int n)
     * String decrypt(final String encryptedText, final int n)
     * <p>
     * For both methods:
     * If the input-string is null or empty return exactly this value!
     * If n is <= 0 then return the input text.
     */

    public static void main(String[] args) {
        String s = SimpleEncryption1AlternatingSplit.encrypt("This is a test!", 2);

        System.out.println(s);
        s = SimpleEncryption1AlternatingSplit.decrypt("hskt svr neetn!Ti aai eyitrsig", 1);
        System.out.println(s);
    }

    public static String encrypt(final String text, final int n) {

        if (n <= 0 || text == null || text.isEmpty()) {
            return text;
        }

        String result = "";
        String textToEncrypt = text;

        for (int i = 0; i < n; i++) {
            result = "";

            result += SimpleEncryption1AlternatingSplit.concatenateChars(true, textToEncrypt);
            result += SimpleEncryption1AlternatingSplit.concatenateChars(false, textToEncrypt);

            textToEncrypt = result;

        }

        return result;
    }

    public static String concatenateChars(boolean isSecondChar, String text) {

        int startingPoint = isSecondChar ? 1 : 0;
        String result = "";

        for (int j = startingPoint; j < text.length(); j += 2) {
            String letter = text.substring(j, j + 1);
            result += letter;
        }

        return result;
    }

    public static String decrypt(final String encryptedText, final int n) {

        if (n <= 0 || encryptedText == null || encryptedText.isEmpty()) {
            return encryptedText;
        }

        int halfwayPoint = encryptedText.length() / 2;
        String result = "";
        String textToDecrypt = encryptedText;

        for (int j = 0; j < n; j++) {

            result = "";
            String firstPart = textToDecrypt.substring(0, halfwayPoint);
            System.out.println(firstPart.length());
            String secondPart = textToDecrypt.substring(halfwayPoint, textToDecrypt.length());
            System.out.println(secondPart.length());

            for (int i = 0; i < halfwayPoint + 1; i++) {

                if (i >= firstPart.length() && i >= secondPart.length()) {
                    break;
                }

                if (i >= firstPart.length()) {
                    result += secondPart.substring(i, i + 1);
                    continue;
                }

                if (i >= secondPart.length()) {
                    result += firstPart.substring(i, i + 1);
                    continue;
                }

                result += secondPart.substring(i, i + 1) + firstPart.substring(i, i + 1);
            }

            textToDecrypt = result;

        }

        return result;

    }


}
