package lille1.dungeon.tests.model.tray.room;

import lille1.dungeon.model.tray.room.Room;
import lille1.dungeon.tests.model.tray.BaseDungeonTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Created by nsvir on 06 Oct 15.
 */
public class RoomTest extends BaseDungeonTest {

    private final static String defaultRoomName = "Entrance";
    private Room defaultRoom;
    private String direction;
    private Room directionRoom;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        direction = "North";
        directionRoom = new Room(direction);
        defaultRoom = new Room(defaultRoomName);

    }

    @Test
    public void testAddDirectionRoom() throws Exception {
        defaultRoom.addDirectionRoom(direction, directionRoom);
        assertTrue(defaultRoom.isDirectionUsed(direction));
        assertEquals(directionRoom, defaultRoom.builderNextRoom(direction));
    }

    @Test
    public void testNextNonexistentRoom() throws Exception {
        assertEquals(defaultRoom, defaultRoom.builderNextRoom(direction));
    }

    @Test
    public void testNextExistentRoom() throws Exception {
        defaultRoom.addDirectionRoom(direction, directionRoom);
        assertEquals(directionRoom, defaultRoom.builderNextRoom(direction));
    }

    @Test
    public void testIsFinished() throws Exception {
        assertFalse(defaultRoom.isFinished());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(defaultRoomName, defaultRoom.getName());
    }

    @Test
    public void testIsDirectionUsed() throws Exception {
        assertFalse(defaultRoom.isDirectionUsed(direction));
        defaultRoom.addDirectionRoom(direction, directionRoom);
        assertTrue(defaultRoom.isDirectionUsed(direction));
    }
}
