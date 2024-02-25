import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

// The count should start from zero
// Labels such as (LOOP) should be skipped

public class LabelTable {
    public static int variableSymbolStartValue = 16;

    public static HashMap<String, String> labelsMap = new HashMap<>(){{
        put("R0", "0");
        put("R1", "1");
        put("R2", "2");
        put("R3", "3");
        put("R4", "4");
        put("R5", "5");
        put("R6", "6");
        put("R7", "7");
        put("R8", "8");
        put("R9", "9");
        put("R10", "10");
        put("R11", "11");
        put("R12", "12");
        put("R13", "13");
        put("R14", "14");
        put("R15", "15");
        put("SCREEN", "16384");
        put("KBD", "24576");
        put("SP", "0");
        put("LCL", "1");
        put("ARG", "2");
        put("THIS", "3");
        put("THAT", "4");
    }};

    public void fillTable (String filePath) {
        try {
            int lineCount = 0;

            Scanner fileScanner = new Scanner(new File(filePath));

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().replaceAll(" ", "");

                boolean isContainComment = line.contains("//");
                boolean isCommentedLine = line.indexOf("//") == 0;

                if (!isCommentedLine && !line.isEmpty()) {
                    String formattedLine = isContainComment ? line.substring(0, line.indexOf("//")) : line;

                    System.out.println(formattedLine);

                    if (formattedLine.contains("(")) {
                        String key = formattedLine.replace("(", "").replace(")", "");

                        if (!labelsMap.containsKey(key)) {
                            labelsMap.put(key, String.valueOf(lineCount));
                        }
                    } else {
                        lineCount++;
                    }

//                    Pattern pattern = Pattern.compile("[a-zA-Z]");
//
//                    if (formattedLine.contains("@") && pattern.matcher(formattedLine).find()) {
//                        String key = formattedLine.replace("@", "");
//
//                        if (!labelsMap.containsKey(key)) {
//                            labelsMap.put(key, String.valueOf(variableSymbolStartValue));
//                            variableSymbolStartValue++;
//                        }
//                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
