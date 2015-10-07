package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.InvalidActionException;
import lille1.dungeon.model.tray.Dungeon;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public interface Action {

    /**
     * check if the action is concerned by the user command
     * @param string the user input
     * @return A none null action if the action wants to take the command
     * */
    Action interpretCommand(String string);

    /**
     * apply the action to the dungeon
     * @param myDungeon the dungeon to apply the action
     * @return the message to display if the action is valid
     * @throws InvalidActionException if the action is invalid and fill it with the message to display
     */
    String apply(Dungeon myDungeon) throws InvalidActionException;
}
