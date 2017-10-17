package codewars.kata;

public class StripComments {

    public static void main(String[] args) {

        System.out.println(StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples",
                new String[]{"#", "!"}));

        System.out.println("--------");

        System.out.println(StripComments.stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"}));
    }

    public static String stripComments(String text, String[] commentSymbols) {

        String[] lines = text.split("\n");

        for (int i = 0; i < lines.length; i++) {

            for (String s : commentSymbols) {
                String regex = s + ".*\n?";

                lines[i] = lines[i].replaceAll(regex, "");
                lines[i] = lines[i].replaceAll(" \n", "");
                lines[i] = lines[i].replaceAll(" $", "");
            }

            if (i != lines.length - 1) {
                lines[i] = lines[i] + "\n";
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String l : lines) {
            sb.append(l);
        }

        return sb.toString();
    }
}