package lille1.dungeon.model.tray;

import java.util.Map;
import java.util.TreeMap;

public class Room {

    private String name;
    private Map<String, Room> rooms = new TreeMap<String, Room>() {
    };

    public Room(String name) {
	this.name = name;
    }

    protected void addDirectionRoom(String direction, Room room) {
	    this.rooms.put(direction, room);
    }

    public Room nextRoom(String direction) {
        if(rooms.get(direction)==null) return this;
	    return rooms.get(direction);
    }

    public boolean isFinished() {
	return false;
    }

    public String getName() {
	return this.name;
    }

    public boolean isDirectionUsed(String currentDir) {
        return this.rooms.get(currentDir) != null;
    }

    public String toString() { return this.name; }
}
