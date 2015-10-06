package lille1.dungeon.tests;

import lille1.dungeon.model.chars.Hero;
import lille1.dungeon.model.commands.CommandTypes;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.model.tray.MonsterRoom;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

class DungeonTest {
    protected Dungeon dungeon;

    @Before
    public void createDungeon() {
        Hero h = new Hero("test");
        dungeon = new Dungeon(Dungeon.GENERATION_TEST_KEY, h);
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
        CommandTypes go = CommandTypes.MOVE;
        go.storeCmd("go ezdez");
        try {
            dungeon.interpretCommand(go);
        } catch (MonsterRoom.MonsterNotDeadException e) {
            e.printStackTrace();
        }
        assertEquals("entrance", dungeon.getCurrentRoom());
        assertFalse(dungeon.gameIsFinished());
    }
}