package lille1.dungeon.model.tray.room;

public class Exit extends Room {

    public Exit() {
        super("exit");
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
