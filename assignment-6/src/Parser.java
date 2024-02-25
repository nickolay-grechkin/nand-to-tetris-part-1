import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.regex.Pattern;

// Move file reading and sanitizing to separate class
// Handle case when comment located on the same page with command

public class Parser {
    final String COMMENT_SYMBOL = "//";
    final String AT_SYMBOL = "@";
    private int variableSymbolStartValue = 16;

    LinkedList<String> sanitizedFileContent = new LinkedList<>();

    Command command;

    public Parser(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                boolean isCommentedLine = line.contains(COMMENT_SYMBOL);

                boolean isLabelSymbol = line.contains("(");

                if (!isCommentedLine && !line.isEmpty() && !isLabelSymbol) {
                    sanitizedFileContent.add(line.replaceAll(" ", ""));
                }
            }
            // System.out.println(sanitizedFileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasMoreCommands() {
         return !sanitizedFileContent.isEmpty();
    }

    public void advance() {
        String line = sanitizedFileContent.pop();

        if (line.contains(AT_SYMBOL)) {
            Pattern pattern = Pattern.compile("[a-zA-Z]");

            if (!pattern.matcher(line).find()) {
                command = new ACommand(line);
                return;
            }

            command = new Label(line);
            return;
        }

        if (!line.contains("(")) {
            command = new CCommand(line);
        }
    }
}
