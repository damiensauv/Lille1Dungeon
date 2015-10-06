package lille1.dungeon.model.action;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public abstract class BaseAction implements Action {

    protected String userInput;

    public BaseAction(String userInput) {
        this.userInput = userInput;
    }
}
