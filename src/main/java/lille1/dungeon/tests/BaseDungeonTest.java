package lille1.dungeon.tests;

import lille1.dungeon.model.action.Action;
import lille1.dungeon.model.action.Go;
import lille1.dungeon.model.chars.Hero;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.model.tray.Room;
import org.junit.Before;

/**
 * Created by nanosvir on 07 Oct 15.
 */
public class BaseDungeonTest {

    Dungeon dungeon;
    Room directionRoom;
    String direction;
    Room entranceRoom;
    Hero hero;
    String wrongDirection;

    @Before
    public void setUp() throws Exception {
        hero = new Hero("Jack");
        wrongDirection = "not north";
        entranceRoom = new Room("entrance");
        directionRoom = new Room(direction);
        direction = "north";
        entranceRoom.addDirectionRoom(direction, directionRoom);
        this.dungeon = new Dungeon(entranceRoom, hero);
    }

}
