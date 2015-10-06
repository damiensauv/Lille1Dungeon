package lille1.dungeon.tests;

import junit.framework.TestCase;
import lille1.dungeon.exceptions.RoomLockedException;
import lille1.dungeon.model.chars.Monster;
import lille1.dungeon.model.tray.MonsterRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by nanosvir on 06 Oct 15.
 */
public class MonsterRoomTest {

    private MonsterRoom defaultRoom;
    private Monster defaultMonster;
    private String defaultRoomName;

    @Before
    public void setUp() throws Exception {
        defaultRoomName = "Entrance";
        defaultMonster = new Monster("Jack");
        defaultRoom = new MonsterRoom(defaultMonster, defaultRoomName);
    }

    @Test(expected = RoomLockedException.class)
    public void testNextRoomWithMonster() throws RoomLockedException {
            defaultRoom.nextRoom("noDirection");
    }

    @Test
    public void testNextRoomWithDeadMonster() throws Exception {
        defaultRoom.getMonster().setLife(0);
        defaultRoom.nextRoom("noDirection");
    }

    public void testProcessFight() throws Exception {
        fail("Not implemented");
    }
}