public class ACommand implements Command {
    private final String value;

    public ACommand(String fileLine) {
        value = fileLine.replace("@", "");
    }

    public String value() {
        return value;
    }

    public String translate() {
        String binaryValue = Integer.toBinaryString(Integer.parseInt(value));

        return String.format("%16s", binaryValue).replace(' ', '0');
    }
}
