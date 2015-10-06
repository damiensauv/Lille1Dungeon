package lille1.dungeon.controller;

import lille1.dungeon.exceptions.CommandUnrecognizedException;
import lille1.dungeon.model.action.Action;

/**
 * Created by Thotol on 30/09/2015.
 */
public interface Controller {

    Action openInput() throws CommandUnrecognizedException;
    void notify(String not);
    String getText();
}
