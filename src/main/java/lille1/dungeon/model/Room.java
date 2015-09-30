package lille1.dungeon.model;

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
	return rooms.get(direction);
    }

    public boolean isFinished() {
	return false;
    }

    public String getName() {
	return this.name;
    }

    public Map<String, Room> getRoomMap() {
        return this.rooms;
    }
}
