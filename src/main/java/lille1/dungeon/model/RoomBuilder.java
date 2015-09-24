package lille1.dungeon.model;

import java.util.Map;

public class RoomBuilder {

    private Map<String, Room> rooms;
    private Room current;
    private Room entrance;

    public RoomBuilder(String entranceName) {
	this.current = new Room(entranceName);
	this.entrance = this.current;
    }

    public void addDirection(String direction, String name) {
	this.current.addDirectionRoom(direction, new Room(name));
    }

    public void move(String direction) {
	this.current = this.current.nextRoom(direction);
    }

    public void move(String direction, String fromDirection) {
	Room from = this.current;
	this.move(direction);
	this.addDirection(fromDirection, fromDirection);
    }

    public Room create() {
	return this.entrance;
    }
}
