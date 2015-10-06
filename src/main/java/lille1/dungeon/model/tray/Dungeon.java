package lille1.dungeon.model.tray;

import lille1.dungeon.exceptions.MonsterNotDeadException;
import lille1.dungeon.exceptions.RoomIsNotAMonsterRoomException;
import lille1.dungeon.model.chars.*;
import lille1.dungeon.model.chars.Character;
import lille1.dungeon.model.commands.CommandTypes;

public class Dungeon {

    public static final int GENERATION_TEST_KEY = 6;

    private Room current;
    private Hero badassHero;

    public Dungeon(int level, Hero h) {
        DungeonBuilder db = new DungeonBuilder(level);
        this.current = db.create();
        this.badassHero = h;
    }

    public void interpretCommand(CommandTypes order) throws MonsterNotDeadException, RoomIsNotAMonsterRoomException {
        if (order == CommandTypes.MOVE) this.current = current.nextRoom(order.getCmd());
        //if(order == CommandTypes.USE)   this.current = current.nextRoom(order.getCmd());
        if (order == CommandTypes.KILL) {
            if (this.current instanceof MonsterRoom) {
                MonsterRoom mr = (MonsterRoom) this.getCurrentRoom();
                mr.processFight(this.badassHero);
            } else throw new RoomIsNotAMonsterRoomException();
        }
    }

    public String getCurrentRoomName() {
        return this.current.getName();
    }

    public Room getCurrentRoom() {
        return this.current;
    }

    public boolean gameIsFinished() {
        return this.gameIsWon() || this.gameIsLost();
    }

    public boolean gameIsWon() {
        if ((this.current instanceof Exit) && (!(this.badassHero.isDead()))) return true;
        return false;
    }

    public boolean gameIsLost() {
        if (this.badassHero.isDead()) return true;
        return false;
    }

    public Character getHero() {
        return this.badassHero;
    }
}
