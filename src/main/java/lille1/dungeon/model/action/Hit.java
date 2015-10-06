package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.InvalidActionException;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.model.tray.MonsterRoom;
import lille1.dungeon.utils.Parser;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public class Hit extends BaseAction {

    private static final String PREFIX = "hit";
    private static final String NotAMonsterRoom = "THis is not a monster room";

    public Hit(String userInput) {
        super(userInput);
    }

    @Override
    public boolean interpreteCommand(String string) {
        userInput = string;
        return Parser.isPrefix(Hit.PREFIX, string);
    }

    @Override
    public String apply(Dungeon myDungeon) throws InvalidActionException {
        if (myDungeon.getCurrentRoom() instanceof MonsterRoom) {
            MonsterRoom monsterRoom = (MonsterRoom) myDungeon.getCurrentRoom();
            if(monsterRoom.getMonster()!=null) {
                monsterRoom.getMonster().hit(myDungeon.getHero());
            }
        } else throw new InvalidActionException(Hit.NotAMonsterRoom);
        return "Hit!!";
    }

    @Override
    public Action newInstance() {
        return new Hit(userInput);
    }
}
