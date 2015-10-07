package lille1.dungeon.tests.model.tray.room;

import junit.framework.TestCase;
import lille1.dungeon.model.tray.room.Exit;
import org.junit.Test;

/**
 * Created by nanosvir on 06 Oct 15.
 */
public class ExitTest extends TestCase {

    @Test
    public void testIsFinished() throws Exception {
        TestCase.assertTrue(new Exit().isFinished());
    }
}
