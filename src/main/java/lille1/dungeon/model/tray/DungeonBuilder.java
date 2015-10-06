package lille1.dungeon.model.tray;

import lille1.dungeon.exceptions.MonsterNotDeadException;
import lille1.dungeon.model.chars.Monster;

import java.util.Map;
import java.util.Random;

/**
 * Created by Thotol on 30/09/2015.
 */
public class DungeonBuilder {

    public static final int TRUE_LEVEL_MODIFIER = 2;

    private static final String[] possibleDirections = new String[4];
    private static final String[] possibleTypes = {"intersection", "monster"};
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
        while (current.isDirectionUsed(currentDirection))
            currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];
        addDirection(currentDirection, "Exit");
        String commingFrom = this.getOppositeDirection(currentDirection);
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
        if (name.equals("exit") || name.equals("Exit")) roomToCreate = new Exit();
        else roomToCreate = new Room(name);
        if (name.equals("monster")) {
            roomToCreate = new MonsterRoom(new Monster("bizuth", 100, 1), "rummmmeenn");
        }
        this.current.addDirectionRoom(direction, roomToCreate);
    }

    public void addDirection(String direction, Room previous) {
        this.current.addDirectionRoom(direction, previous);
    }

    public void move(String direction) {
        this.current = this.current.builderMove(direction);
    }

    public void move(String direction, String fromDirection) {
        Room from = this.current;
        this.move(direction);
        this.addDirection(fromDirection, from);
    }

    public Room create() {
        int trueLevel = this.level * TRUE_LEVEL_MODIFIER;
        int roomsLeft = trueLevel;
        Random rand = new Random();
        while (roomsLeft != 0) {
            int nextType = rand.nextInt(2);
            String currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];
            while (current.isDirectionUsed(currentDirection))
                currentDirection = possibleDirections[rand.nextInt(possibleDirections.length - 1)];
            addDirection(currentDirection, possibleTypes[nextType]);
            String commingFrom = this.getOppositeDirection(currentDirection);
            move(currentDirection, commingFrom);
            roomsLeft -= 1;
        }
        addExit();
        return this.entrance;
    }

}
