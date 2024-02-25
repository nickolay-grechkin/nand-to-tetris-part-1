import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("D:\\self-study\\courses\\nand-to-tetris\\nand-to-tetris-repo\\assignment-6\\src\\files\\Add.asm");

        try {
            PrintWriter writer = new PrintWriter("Add.hack");

            LabelTable labelTable = new LabelTable();
            labelTable.fillTable("D:\\self-study\\courses\\nand-to-tetris\\nand-to-tetris-repo\\assignment-6\\src\\files\\Add.asm");

            ACommand aCommandTest = new ACommand("@0");
            CCommand cCommandTest = new CCommand("M=D");

            System.out.println("A test command: " + aCommandTest.translate());
            System.out.println("C test command: " + cCommandTest.translate());

            while (parser.hasMoreCommands()) {
                parser.advance();

                String binaryToWrite = null;

                if (parser.command instanceof ACommand) {
                    ACommand aCommand = (ACommand) parser.command;
                    // MnemonicTranslator.translateACommand(aCommand.value());
                    binaryToWrite = aCommand.translate();
                    // System.out.println(aCommand.translate());
                }

                if (parser.command instanceof CCommand) {
                    CCommand cCommand = (CCommand) parser.command;
                    binaryToWrite = cCommand.translate();
                    //System.out.println(cCommand.translate());
                }

                if (parser.command instanceof Label) {
                    Label label = (Label) parser.command;
                    binaryToWrite = label.translate();
                }

//                System.out.println(LabelTable.labelsMap);

                if (binaryToWrite != null) {
                    writer.println(binaryToWrite);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
