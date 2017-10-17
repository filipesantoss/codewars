package codewars.kata.kyu6;

public class TheEnigmaMachineThePlugboard {

    // https://www.codewars.com/kata/5523b97ac8f5025c45000900

    private String wires;

    private static final int MAXIMUM_WIRES = 10;
    private static final int CHARS_PER_WIRE = 2;

    public TheEnigmaMachineThePlugboard(String wires) throws InvalidPlugboardWiresException {

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
