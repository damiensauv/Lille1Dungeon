package lille1.dungeon.model.action;

import lille1.dungeon.exceptions.InvalidCommand;
import lille1.dungeon.utils.Parser;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public abstract class BaseAction implements Action {

    private String userInput;

    protected BaseAction(String userInput) {
        this.userInput = userInput;
    }

    protected BaseAction() {

    }

    @Override
    public Action interpretCommand(String string) {
        if (Parser.isPrefix(this.getPrefix(), string)) return newActionInstance(string);
        return null;
    }

    protected Action newActionInstance(String string) {
        try {
            return this.getClass().getConstructor(String.class).newInstance(string);
        } catch (Exception e) {
            System.err.println("You must implement a public constructor with a String parameter for " + this.getClass().toString());
            return null;
        }
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
