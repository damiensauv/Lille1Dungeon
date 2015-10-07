package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.InvalidCommand;
import lille1.dungeon.utils.Parser;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public abstract class BaseAction implements Action {

    private String userInput;

    public BaseAction(String userInput) {
        this.userInput = userInput;
    }

    public BaseAction() {

    }

    protected String getUserInput() {
        assert(userInput != null);
        return userInput;
    }

    protected String getPostCommand() throws InvalidCommand {
        assert(userInput != null);
        return Parser.getPostCommand(userInput);
    }

    /**
     * @return the prefix of the expected command
     */
    protected abstract String getPrefix();
}
