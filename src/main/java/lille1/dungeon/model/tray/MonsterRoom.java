package lille1.dungeon.model.tray;

import lille1.dungeon.exceptions.MonsterNotDeadException;
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

    public Room nextRoom(String direction) throws MonsterNotDeadException {
        if(this.monsterInside.isDead()) throw new MonsterNotDeadException();
        return rooms.get(direction);
    }

    public Monster getMonster() {
        return this.monsterInside;
    }
}
