package lille1.dungeon.tests.model.chars;

import lille1.dungeon.model.chars.Monster;

import junit.framework.TestCase;
import lille1.dungeon.model.stuff.Key;
import lille1.dungeon.model.stuff.Potion;
import lille1.dungeon.model.stuff.Weapons;
import lille1.dungeon.model.tray.Dungeon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by damien on 07/10/15.
 */
public class MonsterTest {

    Monster m1;


    @Before
    public void setUp() throws Exception {
        m1 = new Monster("Doe");
    }

    @Test
    public void testGetSetters() {
        assertEquals(50, m1.getLife());
        assertEquals(15, m1.getStrength());

        assertNotNull(m1.getInventory());
    }

    @Test
    public void testDead(){
        assertFalse(m1.isDead());
    }

    @Test
    public void testDrop(){
        assertNotNull(m1.dropObject());
    }

}
