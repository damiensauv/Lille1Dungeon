package lille1.dungeon.exceptions;

/**
 * Created by nanosvir on 07 Oct 15.
 */
public class InvalidDirectionException extends Exception {

    private final String direction;

    public InvalidDirectionException(String direction) {
        this.direction = direction;
    }

    public String getMessage() {
        return direction + " is not a valid direction";
    }

}
