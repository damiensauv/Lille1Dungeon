package lille1.dungeon.model.tray.room;

import lille1.dungeon.exceptions.MonsterNotDeadException;

import java.util.Map;
import java.util.TreeMap;

public class Room {

    protected String name;
    protected Map<String, Room> rooms = new TreeMap<>();

    public Room(String name) {
	this.name = name;
    }

    /**
     * Add an adjacent room with his direction
     * @param direction the direction in the current room to go in the next one
     * @param room the adjacent room
     */
    public void addDirectionRoom(String direction, Room room) {
	    this.rooms.put(direction, room);
    }

    public Room nextRoom(String direction) throws MonsterNotDeadException {
        Room room = rooms.get(direction);
        if(room ==null) return this;
	    return room;
    }

    public Room builderMove(String direction) {
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
