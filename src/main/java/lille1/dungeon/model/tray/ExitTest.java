package lille1.dungeon.model.tray;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by nanosvir on 06 Oct 15.
 */
public class ExitTest extends TestCase {

    @Test
    public void testIsFinished() throws Exception {
        assertTrue(new Exit().isFinished());
    }
}