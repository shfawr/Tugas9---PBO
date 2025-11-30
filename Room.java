

/**
 * Write a description of class Room here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.util.Set;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }


    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }


    public Room getExit(String direction) {
        return exits.get(direction);
    }


    public String getShortDescription() {
        return description;
    }


    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    public String getExitString() {
        StringBuilder builder = new StringBuilder("Exits:");
        Set<String> keys = exits.keySet();
        for (String dir : keys) {
            builder.append(" ").append(dir);
        }
        return builder.toString();
    }
}
