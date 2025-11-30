
/**
 * Write a description of class Parser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Parser {
    private CommandWords commandWords;
    private Scanner reader;

    public Parser() {
        commandWords = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");

        String inputLine = reader.nextLine();
        String word1 = null;
        String word2 = null;

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
        }
        if (tokenizer.hasNext()) {
            word2 = tokenizer.next();
        }
        tokenizer.close();

        if (commandWords.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            // command tidak dikenal
            return new Command(null, word2);
        }
    }

    /**
     * Mengembalikan daftar command valid,
     * supaya bisa dipakai di printHelp().
     */
    public String getCommandList() {
        return commandWords.getCommandList();
    }
}
