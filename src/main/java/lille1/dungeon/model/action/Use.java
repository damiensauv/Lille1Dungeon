package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.InvalidActionException;
import lille1.dungeon.exceptions.InvalidCommand;
import lille1.dungeon.exceptions.InvalidDirectionException;
import lille1.dungeon.exceptions.RoomLockedException;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.model.tray.MonsterRoom;
import lille1.dungeon.utils.Parser;

/**
 * Created by damien on 07/10/15.
 */
public class Use extends BaseAction {

    private static final String INVALID_COMMAND = "Invalid command";
    private static final String THIS_IS_NOT_A_MONSTER_ROOM = "THis is not a monster room";

    public Use(String userInput) {
        super(userInput);
    }

    public Use() {
    }

    @Override
    protected String getPrefix() {return "use";}

    @Override
    public Action interpretCommand(String string) {
        if (Parser.isPrefix(this.getPrefix(), string)) return new Use(string);
        return null;
    }

    @Override
    public String apply(Dungeon myDungeon) throws InvalidActionException {
        String whatUse = null;
        try {
            whatUse = getPostCommand();
            if (whatUse.equals("weapon")){

                if (myDungeon.getCurrentRoom() instanceof MonsterRoom) {
                    MonsterRoom monsterRoom = (MonsterRoom) myDungeon.getCurrentRoom();
                    if(monsterRoom.getMonster()!=null) {
                        myDungeon.getHero().useWeapon(monsterRoom.getMonster());
                        monsterRoom.getMonster().hit(myDungeon.getHero());
                    }
                } else throw new InvalidActionException(Use.THIS_IS_NOT_A_MONSTER_ROOM);
                return "Hit!!";

            } else if (whatUse.equals("potion")) {
                myDungeon.getHero().usePotion();
                return "Drink Potion !";
            } else if (whatUse.equals("key")) {
                myDungeon.getHero().useKey();
                return "Try To Open The Doors";
            }
        } catch (InvalidCommand invalidCommand) {
            throw new InvalidActionException(Use.INVALID_COMMAND);
        }
        return "";
    }
}
