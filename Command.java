
/**
 * Write a description of class Command here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Command {
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord) {
        this.commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    /**
     * True jika command tidak dikenal (commandWord == null).
     */
    public boolean isUnknown() {
        return (commandWord == null);
    }

    /**
     * True jika command punya kata kedua (misalnya direction).
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
