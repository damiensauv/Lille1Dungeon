package lille1.dungeon.tests.model.tray;

import lille1.dungeon.model.chars.Hero;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.model.tray.room.Room;
import org.junit.Before;

/**
 * Created by nanosvir on 07 Oct 15.
 */
public class BaseDungeonTest {

    public Dungeon dungeon;
    public Room directionRoom;
    public String direction;
    public Room entranceRoom;
    public Hero hero;
    public String wrongDirection;

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
