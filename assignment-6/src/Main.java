import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("D:\\self-study\\courses\\nand-to-tetris\\nand-to-tetris-repo\\assignment-6\\src\\PongL.asm");

        try {
            PrintWriter writer = new PrintWriter("PongL.hack");

            ACommand aCommandTest = new ACommand("@10");
            CCommand cCommandTest = new CCommand("D;JGT");

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
//                System.out.println(binaryToWrite);

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
