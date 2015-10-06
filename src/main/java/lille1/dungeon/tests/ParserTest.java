package lille1.dungeon.tests;

import junit.framework.TestCase;
import lille1.dungeon.exceptions.InvalidCommand;
import lille1.dungeon.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nanosvir on 06 Oct 15.
 */
public class ParserTest {

    @Test
    public void testIsPrefix(){
        String expected = "go";
        String test = "      " + expected + "          easy   ";
        assertTrue(Parser.isPrefix(expected, test));
    }

    @Test
    public void testIsNotPrefix() {
        String expected = "go";
        String wrongPrefix = "hey";
        String test = "      " + wrongPrefix + "          easy   ";
        assertFalse(Parser.isPrefix(expected, test));
    }

    @Test
    public void testGetPostCommand() throws InvalidCommand {
        String expected = "north";
        String prefix = "go";
        String test = prefix + " " + expected;
        assertEquals(expected, Parser.getPostCommand(test));
    }

    @Test (expected = InvalidCommand.class)
    public void testGetPostCommandInvalid() throws InvalidCommand {
        Parser.getPostCommand("go");
    }

    @Test
    public void testCleanString() {
        String word1 = "hey";
        String word2 = "how";
        String word3 = "are";
        String word4 = "you";
        String noise = "\t   \t    \t   \t\t\t  \t\t";
        String ugly = noise + word1 + noise + word2 + noise + word3 + noise + word4 + noise;
        String expected = word1 + " " + word2 + " " + word3 + " " + word4;
        assertEquals(expected, Parser.cleanString(ugly));

    }
}