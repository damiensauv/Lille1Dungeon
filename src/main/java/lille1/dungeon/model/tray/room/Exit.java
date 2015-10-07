package lille1.dungeon.model.tray.room;

public class Exit extends Room {

    public Exit() {
        super("exit");
    }

    /**
     * @return <code>true</code> because it is the finish room
     */
    @Override
    public boolean isFinished() {
        return true;
    }

}
