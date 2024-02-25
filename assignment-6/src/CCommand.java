public class CCommand implements Command {
    private final String comp;

    private String dest = null;
    private String jump = null;

    public CCommand(String fileLine) {
        int equalSignIndex = fileLine.indexOf("=");
        int commasSignIndex = fileLine.indexOf(";");

        boolean hasDestCommand = equalSignIndex != -1;
        boolean hasJumpCommand = commasSignIndex != -1;

        if (hasDestCommand) {
            dest = fileLine.substring(0, equalSignIndex);
        }

        if (hasJumpCommand) {
            jump = fileLine.substring(commasSignIndex + 1);

            if (hasDestCommand) {
                comp = fileLine.substring(equalSignIndex + 1, commasSignIndex); // if commasSignIndex != -1 and equalSignIndex == -1;
            } else {
                comp = fileLine.substring(0, commasSignIndex); // if commasSignIndex != -1 and equalSignIndex != -1;
            }
            return;
        }

        comp = fileLine.substring(equalSignIndex + 1); // if commasSignIndex = -1 and equalSignIndex != -1;
    }

    public String dest() {
        return CCommandTable.destHashMap.get(dest);
    }

    public String comp() {
        return CCommandTable.compHashMap.get(comp);
    }

    public String jump() {
        return CCommandTable.jumpHashMap.get(jump);
    }

    public String translate() {
        String aBit = comp.contains("M") ? "1" : "0";

        return "111" + aBit + comp() + dest() + jump();
    }
}
