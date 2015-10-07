package lille1.dungeon.model.tray.room;

import lille1.dungeon.exceptions.InvalidDirectionException;
import lille1.dungeon.exceptions.RoomLockedException;

import java.util.Map;
import java.util.TreeMap;

/**
 * A room is the class that represents the dungeon room and his linked with the other room.
 * A none linked room cannot be accessed unless it is the entrance room.
 */
public class Room {

    protected String name;
    protected Map<String, Room> rooms = new TreeMap<>();

    /**
     * Room constructor
     * @param name the name of the room
     */
    public Room(String name) {
	this.name = name;
    }

    /**
     * Add an adjacent room with his direction
     * @param direction the direction where is the adjacent room
     * @param room the adjacent room
     */
    public void addDirectionRoom(String direction, Room room) {
	    this.rooms.put(direction, room);
    }

    /**
     * Get the next room linked to the direction
     * @param direction the direction
     * @return the adjacent room concerned by the direction
     */
    public Room nextRoom(String direction) throws RoomLockedException, InvalidDirectionException {
        Room room = rooms.get(direction);
        if(room ==null) throw new InvalidDirectionException(direction);
	    return room;
    }

    /**
     * As next room, get the next room linked to the direction
     * Exception that it will always succeed. Even if the door is locked or something.
     * @param direction the direction
     * @return the adjacent room concerned by the direction
     */
    public Room builderNextRoom(String direction) {
        Room room = rooms.get(direction);
        if(room ==null) return this;
        return room;
    }

    /**
     * Check if the room lead to the end of the game
     * @return <code>true</code> if the room is an ending room
     */
    public boolean isFinished() {
	    return false;
    }

    /**
     * Name getter
     * @return the name of the instance
     */
    public String getName() {
	    return this.name;
    }

    /**
     * check if the direction is already used
     * @param currentDir the direction to check
     * @return <code>true</code> if the direction is already taken
     */
    public boolean isDirectionUsed(String currentDir) {
        return this.rooms.get(currentDir) != null;
    }

    /**
     * @return the name of the instance
     */
    public String toString() { return this.name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (name != null ? !name.equals(room.name) : room.name != null) return false;
        return !(rooms != null ? !rooms.equals(room.rooms) : room.rooms != null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        return result;
    }
}
