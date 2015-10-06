package lille1.dungeon.model.commands;

/**
 * Created by Thotol on 06/10/2015.
 */
@Deprecated
public enum CommandTypes {

    MOVE(3), USE(4), KILL(3);

    private final int idSize;
    private String command;

    private CommandTypes(int idSize) {
        this.idSize = idSize;
    }

    public void storeCmd(String cmd) {
        this.command = cmd.substring(this.idSize);
    }

    public String getCmd() {
        return this.command;
    }

}
