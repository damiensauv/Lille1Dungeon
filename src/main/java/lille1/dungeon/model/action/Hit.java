package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.InvalidActionException;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.model.tray.room.MonsterRoom;
import lille1.dungeon.utils.Parser;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public class Hit extends BaseAction {

    private static final String THIS_IS_NOT_A_MONSTER_ROOM = "THis is not a monster room";
    public static Action Instance = new Hit();

    protected Hit(String string) {
        super(string);
    }

    protected Hit() {
        super();
    }

    @Override
    protected String getPrefix() {
        return "hit";
    }

    @Override
    public String apply(Dungeon myDungeon) throws InvalidActionException {
        if (myDungeon.getCurrentRoom() instanceof MonsterRoom) {
            MonsterRoom monsterRoom = (MonsterRoom) myDungeon.getCurrentRoom();
            if (monsterRoom.getMonster() != null) {
                monsterRoom.processFight(myDungeon.getHero());
                if (monsterRoom.getMonster() != null)
                monsterRoom.getMonster().hit(myDungeon.getHero());
            }
        } else throw new InvalidActionException(Hit.THIS_IS_NOT_A_MONSTER_ROOM);
        return "Hit!!";
    }
}
