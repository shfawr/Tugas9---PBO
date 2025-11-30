
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }


    private void createRooms() {
        Room gerbang, lobi, labRPL, labJarkom, kantin, perpustakaan;

        gerbang = new Room("at the main gate of Informatics campus");
        lobi = new Room("in the lobby, students are passing by");
        labRPL = new Room("inside the Software Engineering lab");
        labJarkom = new Room("inside the Computer Networks lab");
        kantin = new Room("at the campus canteen, smells of food everywhere");
        perpustakaan = new Room("inside a quiet library full of books");

        // set hubungan antar ruangan
        gerbang.setExit("east", lobi);

        lobi.setExit("west", gerbang);
        lobi.setExit("north", labRPL);
        lobi.setExit("south", labJarkom);
        lobi.setExit("east", kantin);

        labRPL.setExit("south", lobi);
        labRPL.setExit("east", perpustakaan);

        labJarkom.setExit("north", lobi);

        kantin.setExit("west", lobi);
        kantin.setExit("north", perpustakaan);

        perpustakaan.setExit("west", labRPL);
        perpustakaan.setExit("south", kantin);

        currentRoom = gerbang;  // posisi awal
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing. Goodbye!");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Campus Adventure!");
        System.out.println("This is a small text-based adventure around Informatics campus.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private void printHelp() {
        System.out.println("You are a student exploring the Informatics campus.");
        System.out.println("Your command words are:");
        System.out.println(parser.getCommandList());
        System.out.println("Example: go north");
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        return true;
    }

    private void look() {
        System.out.println(currentRoom.getLongDescription());
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door in that direction!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    
    private boolean processCommand(Command command) {
        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            return quit(command);
        } else if (commandWord.equals("look")) {
            look();
        }

        return false;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
