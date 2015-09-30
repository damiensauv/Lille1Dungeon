package lille1.dungeon.model;

import java.util.Map;
import java.util.Random;

/**
 * Created by Thotol on 30/09/2015.
 */
public class DungeonBuilder {

    private static final String[] possibleDirections = new String[4];
    private Map<String, Room> rooms;
    private Room current;
    private Room entrance;

    public DungeonBuilder(int level) {

        this.entrance = new Room("entrance");
        this.current = entrance;

        if (level == Dungeon.GENERATION_TEST_KEY) {
            int trueLevel = 5;
            int roomsLeft = trueLevel;
            Random rand = new Random();

            System.out.println("Creating the Level");

            String[] possibleTypes = {"intersection"};

            while (roomsLeft != 0) {
                Room currentRoom = getCurrentRoom();
                int nextType = 0;
                String currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];

                while (this.isDirectionUsed(currentDirection,currentRoom))
                    currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];

                addDirection(currentDirection, possibleTypes[nextType]);

                String commingFrom = this.getOppositeDirection(currentDirection);


                System.out.println(commingFrom + " " + roomsLeft);
                move(currentDirection, commingFrom);
                roomsLeft -= 1;
            }

            addDirection("west", "Exit");
            move("west");
        }
    }

    private void initDestArray() {
        possibleDirections[0] = "north";
        possibleDirections[1] = "south";
        possibleDirections[2] = "east";
        possibleDirections[3] = "west";
    }

    private boolean isDirectionUsed(String currentDir, Room roomToCheck) {
        return roomToCheck.getRoomMap().get(currentDir) != null;
    }

    private String getOppositeDirection(String goingTo) {
        String comingFrom = "";
        if (goingTo.equals(possibleDirections[0]))
            comingFrom = possibleDirections[1];
        if (goingTo.equals(possibleDirections[1]))
            comingFrom = possibleDirections[0];
        if (goingTo.equals(possibleDirections[2]))
            comingFrom = possibleDirections[3];
        if (goingTo.equals(possibleDirections[3]))
            comingFrom = possibleDirections[2];
        return comingFrom;
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
