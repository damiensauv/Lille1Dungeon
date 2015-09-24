public class Exit extends Room {

    public Exit() {
	super("exit");
    }

    @override
    public boolean isFinished() {
	return true;
    }

}
