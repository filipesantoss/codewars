package codewars.kata.kyu6;

public class Plugboard {

    /**
     * In this series of Kata, we will be implementing a software version of the Enigma Machine.
     * <p>
     * The Enigma Machine was a message enciphering/deciphering machine used during the Second World War for disguising the content of military communications.
     * Alan Turing - the father of computing - formulated and developed concepts that are the basis of all computers in use today, he did this in response to the vital need to break those military communications.
     * Turing and his colleagues at Bletchley Park are generally recognised as being responsible for shortening WWII by two years and saving an estimated 22 Million lives.
     * <p>
     * The Enigma Machine consisted of a number of parts: Keyboard for input, rotors and plugboard for enciphering, and lampboard for output.
     * <p>
     * We will simulate input and output with strings, and build the rotors, plugboard and mechanism that used them in software.
     * As we progress the code will become more complex, so you are advised to attempt them in order.
     * <p>
     * Step 1: The plugboard
     * <p>
     * In this Kata, you must implement the plugboard.
     * <p>
     * Physical Description
     * <p>
     * The plugboard crosswired the 26 letters of the latin alphabet togther, so that an input into one letter could generate output as another letter.
     * If a wire was not present, then the input letter was unchanged. Each plugboard came with a maximum of 10 wires, so at least six letters were not cross-wired.
     * <p>
     * For example:
     * <p>
     * If a wire connects A to B, then an A input will generate a B output and a B input will generate an A output.
     * If no wire connects to C, then only a C input will generate a C output.
     * Note
     * <p>
     * In the actual usage of the original Enigma Machine, punctuation was encoded as words transmitted in the stream, in our code, anything that is not in the range A-Z will be returned unchanged.
     */

    public static void main(String[] args) {

        try {
            System.out.println("process: " + new Plugboard("ABAD").process("A"));
        } catch (InvalidPlugboardWiresException e) {
            e.printStackTrace();
        }

    }

    private String wires;

    private static final int MAXIMUM_WIRES = 10;
    private static final int CHARS_PER_WIRE = 2;

    public Plugboard(String wires) throws InvalidPlugboardWiresException {

        if (wires.length() > MAXIMUM_WIRES * CHARS_PER_WIRE) {
            throw new InvalidPlugboardWiresException();
        }

        if (wires.length() % 2 != 0) {
            throw new InvalidPlugboardWiresException();
        }

        for (int i = wires.length() - 1; i > 0; i--) {
            if (wires.indexOf(wires.charAt(i)) != wires.lastIndexOf(wires.charAt(i))) {
                throw new InvalidPlugboardWiresException();
            }
        }

        this.wires = wires;
    }

    public String process(String wire) {

        if (!wires.contains(wire)) {
            return wire;
        }

        int index = wires.indexOf(wire);

        boolean isEven = index % 2 == 0;

        if (isEven && index < wires.length()) {
            return Character.toString(wires.charAt(index + 1));
        }

        if (!isEven && index > 0) {
            return Character.toString(wires.charAt(index - 1));
        }

        return wire;

    }

    private class InvalidPlugboardWiresException extends Exception {
    }
}
