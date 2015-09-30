package lille1.dungeon.model;

public class Dungeon {

    public static final int GENERATION_TEST_KEY = 9001;

    private Room current;

	public Dungeon(int level){
        DungeonBuilder db = new DungeonBuilder(level);
        this.current = db.create();
	}

    public void interpretCommand(String direction) {
	if (direction.startsWith("go ")) {
	    this.current = current.nextRoom(direction.substring(3));
	}
    }

	public String getCurrentRoom() {
		return this.current.getName();
	}

    public boolean gameIsFinished() {
        return this.current.isFinished();
    }


}
