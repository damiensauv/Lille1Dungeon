package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.InvalidActionException;
import lille1.dungeon.exceptions.InvalidCommand;
import lille1.dungeon.exceptions.MonsterNotDeadException;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.utils.Parser;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public class Go extends BaseAction {

    private static final String PREFIX = "go";
    private static final String THE_MONSTER_IS_NOT_DEAD = "The monster is not dead";
    private static final String INVALID_COMMAND = "Invalid command";

    public Go(String userInput) {
        super(userInput);
    }

    public Go() {

    }

    @Override
    public boolean interpreteCommand(String string) {
        userInput = string;
        return Parser.isPrefix(Go.PREFIX, string);
    }

    @Override
    public String apply(Dungeon myDungeon) throws InvalidActionException {
        String direction = null;
        try {
            direction = Parser.getPostCommand(userInput);
            myDungeon.nextRoom(direction);
        } catch (MonsterNotDeadException e) {
            throw new InvalidActionException(Go.THE_MONSTER_IS_NOT_DEAD);
        } catch (InvalidCommand invalidCommand) {
            throw new InvalidActionException(Go.INVALID_COMMAND);
        }
        return "You have successfully been in " + myDungeon.getCurrentRoomName();
    }

    @Override
    public Action newInstance() {
        return new Go(userInput);
    }
}
