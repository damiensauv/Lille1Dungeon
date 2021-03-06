package lille1.dungeon.tests.model.tray;

import lille1.dungeon.model.chars.Hero;
import lille1.dungeon.model.tray.Dungeon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by nanosvir on 06 Oct 15.
 */
public class DungeonTest  {
    protected Dungeon dungeon;

    @Before
    public void createDungeon() {
        Hero h = new Hero("test");
        dungeon = new Dungeon(Dungeon.GENERATION_TEST_KEY, h);
    }

    @Test
    public void initialRoomIsEntrance() {
        assertEquals("entrance", dungeon.getCurrentRoomName());
    }

    @Test
    public void gameNotFinishedAtBeginning() {
        assertFalse(dungeon.gameIsFinished());
    }


}