package lille1.dungeon.model;

import java.util.Map;
import java.util.Random;

/**
 * Created by Thotol on 30/09/2015.
 */
public class DungeonBuilder {

    private static final String[] possibleDirections = new String[4];
    private static final String[] possibleTypes = {"intersection"};
    private Map<String, Room> rooms;
    private Room current;
    private Room entrance;
    private int level;

    public DungeonBuilder(int level) {
        this.entrance = new Room("entrance");
        this.current = entrance;
        this.level = level;
        this.initDestArray();
    }

    private void addExit() {
        Random rand = new Random();
        String currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];
        while (current.isDirectionUsed(currentDirection, current))
            currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];
        addDirection(currentDirection, "Exit");
        String commingFrom = this.getOppositeDirection(currentDirection);
        System.out.println("Exit : "+currentDirection);
    }

    private void initDestArray() {
        possibleDirections[0] = "north";
        possibleDirections[1] = "south";
        possibleDirections[2] = "east";
        possibleDirections[3] = "west";
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

    public void addDirection(String direction, Room previous) {
        this.current.addDirectionRoom(direction, previous);
    }

    public void move(String direction) {
        this.current = this.current.nextRoom(direction);
    }

    public void move(String direction, String fromDirection) {
        Room from = this.current;
        this.move(direction);
        this.addDirection(fromDirection, from);
    }

    public Room create() {
        if (level == Dungeon.GENERATION_TEST_KEY) {
            int trueLevel = 3;
            int roomsLeft = trueLevel;
            Random rand = new Random();

            System.out.println("Creating the Level");

            while (roomsLeft != 0) {
                int nextType = 0;

                String currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];
                while (current.isDirectionUsed(currentDirection, current))
                    currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];

                addDirection(currentDirection, possibleTypes[nextType]);

                System.out.println(currentDirection);

                String commingFrom = this.getOppositeDirection(currentDirection);
                move(currentDirection, commingFrom);
                roomsLeft -= 1;
            }
            addExit();
        }
        return this.entrance;
    }

}
