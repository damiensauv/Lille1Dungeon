package lille1.dungeon.tests;

import lille1.dungeon.controller.ConsoleController;
import lille1.dungeon.exceptions.CommandUnrecognizedException;
import lille1.dungeon.model.action.Go;
import lille1.dungeon.tests.mock.MockScanner;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nanosvir on 07 Oct 15.
 */
public class ConsoleControllerTest {

    MockScanner scanner;
    ConsoleController consoleController;

    @Before
    public void setUp() throws Exception {
        scanner = new MockScanner();
        consoleController = new ConsoleController(scanner);
    }

    @Test (expected = CommandUnrecognizedException.class)
    public void testOpenInputWithoutActions() throws Exception {
        scanner.next("go south");
        consoleController.openInput();
    }

    @Test
    public void testOpenInputWithAction() throws Exception {
        scanner.next("go south");
        consoleController.addAction(Go.Instance);
        consoleController.openInput();
    }

    @Test
    public void testNotify() throws Exception {
        //Really ?
    }

    @Test
    public void testGetText() throws Exception {
        //Really ? :)
    }
}