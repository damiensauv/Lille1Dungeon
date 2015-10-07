package lille1.dungeon.tests;

import lille1.dungeon.model.chars.Hero;

import junit.framework.TestCase;
import lille1.dungeon.model.chars.Hero;
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
public class HeroTest {

    Hero hero1;
    Hero hero2;
    Hero hero3;

    @Before
    public void setUp() throws Exception {
        hero1 = new Hero("John Doe");
        hero2 = new Hero("Chuck Norris", 50, 100);
        hero3 = new Hero("leo");

        hero3.setLife(2);
        hero3.setStrength(4);
    }

    @Test
    public void testGetSetters() {
        assertEquals(50, hero1.getLife());
        assertEquals(15, hero1.getStrength());

        assertEquals(50, hero2.getLife());
        assertEquals(100, hero2.getStrength());

        assertEquals(2, hero3.getLife());
        assertEquals(4, hero3.getStrength());

        assertNotNull(hero1.getInventory());
    }

    @Test
    public void testDead(){
        assertFalse(hero1.isDead());
    }
    
}
