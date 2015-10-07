package lille1.dungeon.tests;

import lille1.dungeon.exceptions.InvalidActionException;
import lille1.dungeon.model.action.Action;
import lille1.dungeon.model.action.Go;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nanosvir on 07 Oct 15.
 */
public class GoTest extends BaseDungeonTest {

    Action action;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        action = new Go();
    }

    @Test
    public void testInterpretValidCommand() throws Exception {
        assertNotNull(this.action.interpretCommand("     go      east    "));
    }

    @Test
    public void testInterpretInvalidCommand() throws InvalidActionException {
        assertNull(this.action.interpretCommand("     not go      east    "));
    }

    @Test
    public void testValidApply() throws Exception {
        Action action = this.action.interpretCommand("go " + direction);
        action.apply(this.dungeon);
        assertEquals(this.directionRoom, this.dungeon.getCurrentRoom());
    }

    @Test (expected = InvalidActionException.class)
    public void testInvalidApply() throws Exception {
        Action action = this.action.interpretCommand("go " + wrongDirection);
        action.apply(this.dungeon);
        assertEquals(this.entranceRoom, this.dungeon.getCurrentRoom());
    }
}