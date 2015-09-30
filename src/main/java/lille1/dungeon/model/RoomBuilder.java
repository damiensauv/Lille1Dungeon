package lille1.dungeon.model;

import java.util.Map;

public class RoomBuilder {

    public static final String[] possibleDirections = new String[4];
    private Map<String, Room> rooms;
    private Room current;
    private Room entrance;

    public RoomBuilder(String entranceName) {
        this.current = new Room(entranceName);
        this.entrance = this.current;
    }

    public void addDirection(String direction, String name) {
        Room roomToCreate;
        if(name.equals("exit")||name.equals("Exit")) roomToCreate = new Exit();
        else roomToCreate = new Room(name);
	    this.current.addDirectionRoom(direction, roomToCreate);
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

    public Room getCurrentRoom() {
        return this.current;
    }
}

