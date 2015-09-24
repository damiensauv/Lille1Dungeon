package lille1.dungeon.model;

public class Dungeon {

    private Room current;

    public void interpretCommand(String direction) {
	if (direction.startWiths("go ")) {
	    this.current = current.nextRoom(direction.substring(3));
	}
    }

    public boolean gameIsFinished() {
	return this.current.isFinished();
    }

    public static void main(String[] args) {
	Map<
	RoomBuilder builder = new RoomBuilder("entrance");
	builder.addDirection("north", "trap");
	builder.addDirection("east", "livingRoom");
	builder.move("east", "west");
	builder.addDirection("north", "lille1.dungeon.model.Exit");
	builder.move("north");
    }
}
