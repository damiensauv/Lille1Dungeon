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
     * @return <code>true</code> if the action is concerned by the user input
     */
    boolean interpretCommand(String string);

    /**
     * apply the action to the dungeon
     * @param myDungeon the dungeon to apply the action
     * @return the message to display if the action is valide
     * @throws InvalidActionException if the action is invalide and fill it with the mesage to display
     */
    String apply(Dungeon myDungeon) throws InvalidActionException;

    /**
     * @return a new instance of the this
     */
    Action newInstance();
}
