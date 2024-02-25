import java.util.HashMap;

public class CCommandTable {
    public static HashMap<String, String> destHashMap = new HashMap<>(){{
        put(null, "000");
        put("M", "001");
        put("D", "010");
        put("MD", "011");
        put("A", "100");
        put("AM", "101");
        put("AD", "110");
        put("AMD", "111");
    }};

    public static HashMap<String, String> jumpHashMap = new HashMap<>(){{
        put(null, "000");
        put("JGT", "001");
        put("JEQ", "010");
        put("JGE", "011");
        put("JLT", "100");
        put("JNE", "101");
        put("JLE", "110");
        put("JMP", "111");
    }};

    public static HashMap<String, String> compHashMap = new HashMap<>(){{
        put("0", "101010");
        put("1", "111111");
        put("-1", "111010");
        put("D", "001100");
        put("A", "110000");
        put("!D", "001101");
        put("!A", "110001");
        put("-D", "001111");
        put("-A", "110011");
        put("D+1", "011111");
        put("A+1", "110111");
        put("D-1", "001110");
        put("A-1", "110010");
        put("D+A", "000010");
        put("D-A", "010011");
        put("A-D", "000111");
        put("D&A", "000000");
        put("D|A", "010101");
        put("M", "110000");
        put("!M", "110001");
        put("-M", "110011");
        put("M+1", "110111");
        put("M-1", "110010");
        put("D+M", "000010");
        put("D-M", "010011");
        put("M-D", "000111");
        put("D&M", "000000");
        put("D|M", "010101");
    }};
}
