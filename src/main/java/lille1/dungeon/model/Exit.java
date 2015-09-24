package lille1.dungeon.model;

public class Exit extends Room {

    public Exit() {
	super("exit");
    }

    @Override
    public boolean isFinished() {
	return true;
    }

}
