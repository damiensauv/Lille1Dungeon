package lille1.dungeon.exceptions;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public class InvalidActionException extends Exception {

    private String message;

    /**
     * Message to display to the user
     *
     * @param outputMessage the displayed message
     */
    public InvalidActionException(String outputMessage) {
        this.message = outputMessage;
    }

    /**
     * @return the message to display to the player
     */
    public String getMessage() {
        return this.message;
    }
}
