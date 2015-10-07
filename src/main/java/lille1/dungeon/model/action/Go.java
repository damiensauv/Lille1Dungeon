package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.*;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.utils.Parser;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public class Go extends BaseAction {

    public static final String PREFIX = "go";
    private static final String THE_MONSTER_IS_NOT_DEAD = "The monster is not dead";
    private static final String INVALID_COMMAND = "Invalid command";

    public Go(String userInput) {
        super(userInput);
    }

    public Go() {

    }

    @Override
    public Action interpretCommand(String string) {
        userInput = string;
        if (Parser.isPrefix(Go.PREFIX, string)) return new Go(string);
        return null;
    }

    @Override
    public String apply(Dungeon myDungeon) throws InvalidActionException {
        String direction = null;
        try {
            direction = Parser.getPostCommand(userInput);
            myDungeon.nextRoom(direction);
        } catch (RoomLockedException e) {
            throw new InvalidActionException(e.getMessage());
        } catch (InvalidCommand invalidCommand) {
            throw new InvalidActionException(Go.INVALID_COMMAND);
        } catch (InvalidDirectionException e) {
            throw new InvalidActionException(e.getMessage());
        }
        return "You have successfully been in " + myDungeon.getCurrentRoomName();
    }
}
