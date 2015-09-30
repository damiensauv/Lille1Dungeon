package lille1.dungeon.model;

import java.util.Random;

/**
 * Created by Thotol on 30/09/2015.
 */
public class DungeonBuilder {

    private Room entrance;

    public DungeonBuilder(int level) {

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
        if(level == Dungeon.GENERATION_TEST_KEY) {
            int trueLevel = 5;
            int roomsLeft = trueLevel;
            Random rand = new Random();

            System.out.println("Creating the Level");

            RoomBuilder.possibleDirections[0] = "north";
            RoomBuilder.possibleDirections[1] = "south";
            RoomBuilder.possibleDirections[2] = "east";
            RoomBuilder.possibleDirections[3] = "west";

            String[] possibleTypes = {"intersection"};

            while(roomsLeft!=0) {
                Room currentRoom = builder.getCurrentRoom();
                int nextType = 0;
                String currentDirection = RoomBuilder.possibleDirections[rand.nextInt(RoomBuilder.possibleDirections.length-1)];
                while(currentRoom.getRoomMap().get(currentDirection)!=null) {
                    currentDirection = RoomBuilder.possibleDirections[rand.nextInt(RoomBuilder.possibleDirections.length-1)];
                }

                builder.addDirection(currentDirection, possibleTypes[nextType]);

                System.out.println(currentDirection + " " + roomsLeft);
                String commingFrom = "";

                if(currentDirection.equals(RoomBuilder.possibleDirections[0])) commingFrom = RoomBuilder.possibleDirections[1];
                if(currentDirection.equals(RoomBuilder.possibleDirections[1])) commingFrom = RoomBuilder.possibleDirections[0];
                if(currentDirection.equals(RoomBuilder.possibleDirections[2])) commingFrom = RoomBuilder.possibleDirections[3];
                if(currentDirection.equals(RoomBuilder.possibleDirections[3])) commingFrom = RoomBuilder.possibleDirections[2];

                System.out.println(commingFrom+ " " + roomsLeft);
                builder.move(currentDirection, commingFrom);
                roomsLeft-=1;
            }

            builder.addDirection("west", "Exit");
            builder.move("west");
        }

        this.entrance = builder.create();
        }

    public Room getEntrance() {
        return entrance;
    }
}
