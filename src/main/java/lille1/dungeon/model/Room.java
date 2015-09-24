package lille1.dungeon.model;

import java.util.Map;

public class Room {

    private String name;
    private Map<String, Room> rooms;

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
}
