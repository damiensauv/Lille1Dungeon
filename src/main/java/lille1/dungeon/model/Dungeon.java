package lille1.dungeon.model;

import java.util.Random;

public class Dungeon {

    private Room current;

	public Dungeon(int level){
		this.current = this.generateDungeon(level);
	}

    public void interpretCommand(String direction) {
	if (direction.startsWith("go ")) {
	    this.current = current.nextRoom(direction.substring(3));
	}
    }

	public String getCurrentRoom() {
		return this.current.getName();
	}

    public boolean gameIsFinished() {
	return this.current.isFinished();
    }

	private Room generateDungeon(int level) {

		RoomBuilder builder = new RoomBuilder("entrance");

		if(level==0) {
			builder.addDirection("north", "trap");
			builder.addDirection("east", "livingRoom");
			builder.move("east", "west");
			builder.addDirection("north", "Exit");
			builder.move("north");
		}
		if(level==1) {
			builder.addDirection("north", "trap");
			builder.addDirection("east", "livingRoom");
			builder.move("east", "west");
			builder.addDirection("north", "Intersection");
			builder.move("north", "south");
			builder.addDirection("north", "Exit");
			builder.move("north");
		}
		if(level == 9001) {
			int trueLevel = 5;
			int roomsLeft = trueLevel;
			Random rand = new Random();

			RoomBuilder.possibleDirections[0] = "north";
			RoomBuilder.possibleDirections[1] = "south";
			RoomBuilder.possibleDirections[2] = "east";
			RoomBuilder.possibleDirections[3] = "west";

			String[] possibleTypes = {"intersection"};

			while(roomsLeft!=0) {
				int nextType = 0;
				String currentDirection = RoomBuilder.possibleDirections[rand.nextInt(RoomBuilder.possibleDirections.length-1)];
				builder.addDirection(currentDirection, possibleTypes[nextType]);

				String commingFrom = "";

				if(currentDirection.equals(RoomBuilder.possibleDirections[0])) commingFrom = RoomBuilder.possibleDirections[1];
				if(currentDirection.equals(RoomBuilder.possibleDirections[1])) commingFrom = RoomBuilder.possibleDirections[0];
				if(currentDirection.equals(RoomBuilder.possibleDirections[2])) commingFrom = RoomBuilder.possibleDirections[3];
				if(currentDirection.equals(RoomBuilder.possibleDirections[3])) commingFrom = RoomBuilder.possibleDirections[2];

				builder.move(currentDirection, commingFrom);
				roomsLeft-=1;
			}

			builder.addDirection("west", "Exit");
			builder.move("west");
		}

		return builder.create();
	}
}
