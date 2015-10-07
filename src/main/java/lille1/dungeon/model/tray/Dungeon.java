package lille1.dungeon.model.tray;

import lille1.dungeon.exceptions.InvalidDirectionException;
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

    private void init(Room room, Hero hero) {
        this.currentRoom = room;
        this.badassHero = hero;
    }

    public Dungeon(Room room, Hero hero) {
        init(room, hero);
    }

    public Dungeon(int level, Hero h) {
        init(new DungeonBuilder(level).create(), h);
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

    public Hero getHero() {
        return this.badassHero;
    }

    public void nextRoom(String direction) throws RoomLockedException, InvalidDirectionException {
        this.setCurrentRoom(getCurrentRoom().nextRoom(direction));
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
