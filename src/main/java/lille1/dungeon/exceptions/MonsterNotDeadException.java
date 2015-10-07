package lille1.dungeon.exceptions;

/**
 * Created by Thotol on 06/10/2015.
 */
public class MonsterNotDeadException extends RoomLockedException {

    public String getMessage() {
        return "A monster is currently in the room and needs to be defeated";
    }
}
