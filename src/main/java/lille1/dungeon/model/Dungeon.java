package lille1.dungeon.model;

public class Dungeon {

    private Room current;

    public void interpretCommand(String direction) {
	if (direction.startsWith("go ")) {
	    this.current = current.nextRoom(direction.substring(3));
	}
    }

    public boolean gameIsFinished() {
	return this.current.isFinished();
    }

	private Room generateDungeon(int level) {
		if(level==0) {
			RoomBuilder builder = new RoomBuilder("entrance");
			builder.addDirection("north", "trap");
			builder.addDirection("east", "livingRoom");
			builder.move("east", "west");
			builder.addDirection("north", "Exit");
			builder.move("north");
			return builder.create();
		}
		if(level==1) {
			RoomBuilder builder = new RoomBuilder("entrance");
			builder.addDirection("north", "trap");
			builder.addDirection("east", "livingRoom");
			builder.move("east", "west");
			builder.addDirection("north", "Intersection");
			builder.move("north", "south");
			builder.addDirection("north", "Exit");
			builder.move("north");
			return builder.create();
		}
		return null;

	}
}
