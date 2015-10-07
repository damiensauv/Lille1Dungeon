package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.InvalidActionException;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.model.tray.room.MonsterAlreadyDeadException;
import lille1.dungeon.model.tray.room.MonsterRoom;
import lille1.dungeon.model.tray.room.NoMonsterException;
import lille1.dungeon.utils.Parser;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public class Hit extends BaseAction {

    private static final String THIS_IS_NOT_A_MONSTER_ROOM = "THis is not a monster room";
    public static Action Instance = new Hit();

    public Hit(String string) {
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
            try {
                if (monsterRoom.processFight(myDungeon.getHero())) {
                    return "You killed the monster!";
                }
            } catch (MonsterAlreadyDeadException e) {
                return "Monster already dead";
            } catch (NoMonsterException e) {
                return "You have just hit a wall..";
            }
        } else throw new InvalidActionException(Hit.THIS_IS_NOT_A_MONSTER_ROOM);
        return "Hit!";
    }
}
