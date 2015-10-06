package lille1.dungeon.model.tray;

import lille1.dungeon.exceptions.MonsterNotDeadException;
import lille1.dungeon.exceptions.RoomLockedException;
import lille1.dungeon.model.action.Action;
import lille1.dungeon.model.chars.*;
import lille1.dungeon.model.chars.Character;

import java.util.List;

public class Dungeon {

    public static final int GENERATION_TEST_KEY = 6;

    private List<Action> actions;
    private Room currentRoom;
    private Hero badassHero;

    public Dungeon(int level, Hero h) {
        DungeonBuilder db = new DungeonBuilder(level);
        this.currentRoom = db.create();
        this.badassHero = h;
    }

    public String getCurrentRoomName() {
        return this.currentRoom.getName();
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public boolean gameIsFinished() {
        return this.gameIsWon() || this.gameIsLost();
    }

    public boolean gameIsWon() {
        if ((this.currentRoom instanceof Exit) && (!(this.badassHero.isDead()))) return true;
        return false;
    }

    public boolean gameIsLost() {
        if (this.badassHero.isDead()) return true;
        return false;
    }

    public Character getHero() {
        return this.badassHero;
    }

    public void nextRoom(String direction) throws RoomLockedException {
        this.setCurrentRoom(getCurrentRoom().nextRoom(direction));
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
