
/**
 * Write a description of class CommandWords here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommandWords {
    private static final String[] validCommands = {
        "go", "help", "quit", "look"
    };

    public CommandWords() {
       
    }


    public boolean isCommand(String word) {
        if (word == null) {
            return false;
        }

        for (String cmd : validCommands) {
            if (cmd.equals(word)) {
                return true;
            }
        }
        return false;
    }


    public String getCommandList() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < validCommands.length; i++) {
            builder.append(validCommands[i]);
            if (i < validCommands.length - 1) {
                builder.append("  ");
            }
        }
        return builder.toString();
    }
}
