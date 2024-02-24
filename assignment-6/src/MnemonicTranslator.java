public class MnemonicTranslator {
    public static String translateACommand(String value) {
        String binaryValue = Integer.toBinaryString(Integer.parseInt(value));

        return String.format("%16s", binaryValue).replace(' ', '0');
    }
}
