package lille1.dungeon.model.tray.room;

import lille1.dungeon.exceptions.InvalidDirectionException;
import lille1.dungeon.exceptions.MonsterNotDeadException;
import lille1.dungeon.exceptions.RoomLockedException;
import lille1.dungeon.model.chars.Hero;
import lille1.dungeon.model.chars.Monster;

/**
 * Created by Thotol on 06/10/2015.
 */
public class MonsterRoom extends Room {

    private Monster monsterInside;

    public MonsterRoom(Monster badguy, String name) {
        super(name);
        this.monsterInside = badguy;
    }

    /**
     * override Room.nextRoom to throw exception if the monster is not dead
     *
     * @param direction the direction
     * @return the next room
     * @throws MonsterNotDeadException if the monster is not dead
     */
    @Override
    public Room nextRoom(String direction) throws RoomLockedException, InvalidDirectionException {
        if (!(this.monsterInside.isDead())) throw new MonsterNotDeadException();
        return super.nextRoom(direction);
    }

    public Monster getMonster() {
        return this.monsterInside;
    }

    public String toString() {
        if (this.monsterInside != null)
            return this.name + " Monster : " + this.monsterInside.getName() + " Life : " + this.monsterInside.getLife();
        return this.name;
    }

    /**
     * /**
     * hit the monster if exists do nothing otherwise
     * @param badassHero the badass hero
     * @throws MonsterAlreadyDeadException if the monster is already dead
     * @throws NoMonsterException if NoMonster is in the room
     * @return <code>true</code> if the hit killed the monster!
     */
    public boolean processFight(Hero badassHero) throws MonsterAlreadyDeadException, NoMonsterException {
        if (monsterInside == null) throw new NoMonsterException();
        if (monsterInside.isDead()) throw new MonsterAlreadyDeadException();
        badassHero.hit(this.monsterInside);
        if (this.monsterInside.isDead()) {
            badassHero.lootObject(this.monsterInside.dropObject());
            return true;
        }
        return false;
    }
}
