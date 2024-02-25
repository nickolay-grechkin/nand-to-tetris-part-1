public class Label implements Command {
    private final String value;

    public Label(String fileLine) {
        if (fileLine.contains("(")) {
            value = fileLine.replace("(", "").replace(")", "");
            return;
        }

        value = fileLine.replace("@", "");
    }

    public String translate() {
        String valueToConvert;

        String labelTableValue = LabelTable.labelsMap.get(value);

        if (labelTableValue != null) {
            valueToConvert = labelTableValue;
        } else {
            if (LabelTable.labelsMap.containsKey(value)) {
                valueToConvert = LabelTable.labelsMap.get(value);
            } else {
                valueToConvert = String.valueOf(LabelTable.variableSymbolStartValue);

                LabelTable.labelsMap.put(value, valueToConvert);
                LabelTable.variableSymbolStartValue++;
            }
        }

        String binaryValue = Integer.toBinaryString(Integer.parseInt(valueToConvert));

        return String.format("%16s", binaryValue).replace(' ', '0');
    }
}
