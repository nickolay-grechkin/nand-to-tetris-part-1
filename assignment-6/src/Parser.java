import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;

public class Parser {
    LinkedList<String> sanitizedFileContent = new LinkedList<>();

    Command command;

    public Parser(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                boolean isCommentedLine = line.contains("//");

                if (!isCommentedLine && !line.isEmpty()) {
                    sanitizedFileContent.add(line);
                }
            }
            System.out.println(sanitizedFileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasMoreCommands() {
         return !sanitizedFileContent.isEmpty();
    }

    public void advance() {
        String line = sanitizedFileContent.pop();

        if (line.contains("@")) {
            command = new ACommand(line);
            return;
        }

        command = new CCommand(line);
    }

}
