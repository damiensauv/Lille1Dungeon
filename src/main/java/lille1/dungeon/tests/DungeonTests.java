package lille1.dungeon.tests;

import lille1.dungeon.model.tray.Dungeon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class DungeonTest {
    protected Dungeon dungeon;

    @Before
    public void createDungeon() {
        dungeon = new Dungeon(Dungeon.GENERATION_TEST_KEY);
    }

    @Test
    public void initialRoomIsEntrance() {
        assertEquals("entrance", dungeon.getCurrentRoom());
    }

    @Test
    public void gameNotFinishedAtBeginning() {
        assertFalse(dungeon.gameIsFinished());
    }

    @Test
    public void nothingHappensWhenGoingInNonExistingDirection() {
        dungeon.interpretCommand("go ezdez");
        assertEquals("entrance", dungeon.getCurrentRoom());
        assertFalse(dungeon.gameIsFinished());
    }
}