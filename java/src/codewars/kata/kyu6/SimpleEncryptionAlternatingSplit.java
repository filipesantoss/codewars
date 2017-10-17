package codewars.kata.kyu6;

public class SimpleEncryptionAlternatingSplit {

    // https://www.codewars.com/kata/57814d79a56c88e3e0000786

    public static String encrypt(final String text, final int n) {

        if (n <= 0 || text == null || text.isEmpty()) {
            return text;
        }

        String result = "";
        String textToEncrypt = text;

        for (int i = 0; i < n; i++) {
            result = "";

            result += SimpleEncryptionAlternatingSplit.concatenateChars(true, textToEncrypt);
            result += SimpleEncryptionAlternatingSplit.concatenateChars(false, textToEncrypt);

            textToEncrypt = result;

        }

        return result;
    }

    private static String concatenateChars(boolean isSecondChar, String text) {

        int startingPoint = isSecondChar ? 1 : 0;
        StringBuilder result = new StringBuilder();

        for (int j = startingPoint; j < text.length(); j += 2) {
            String letter = text.substring(j, j + 1);
            result.append(letter);
        }

        return result.toString();
    }

    public static String decrypt(final String encryptedText, final int n) {

        if (n <= 0 || encryptedText == null || encryptedText.isEmpty()) {
            return encryptedText;
        }

        int halfwayPoint = encryptedText.length() / 2;
        StringBuilder result = new StringBuilder();
        String textToDecrypt = encryptedText;

        for (int j = 0; j < n; j++) {

            result = new StringBuilder();
            String firstPart = textToDecrypt.substring(0, halfwayPoint);
            String secondPart = textToDecrypt.substring(halfwayPoint, textToDecrypt.length());

            for (int i = 0; i < halfwayPoint + 1; i++) {

                if (i >= firstPart.length() && i >= secondPart.length()) {
                    break;
                }

                if (i >= firstPart.length()) {
                    result.append(secondPart.substring(i, i + 1));
                    continue;
                }

                if (i >= secondPart.length()) {
                    result.append(firstPart.substring(i, i + 1));
                    continue;
                }

                result.append(secondPart.substring(i, i + 1)).append(firstPart.substring(i, i + 1));
            }

            textToDecrypt = result.toString();

        }

        return result.toString();

    }


}
