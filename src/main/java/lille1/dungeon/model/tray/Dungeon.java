package lille1.dungeon.model.tray;

import lille1.dungeon.model.commands.CommandTypes;

public class Dungeon {

    public static final int GENERATION_TEST_KEY = 9001;

    private Room current;

	public Dungeon(int level){
        DungeonBuilder db = new DungeonBuilder(level);
        this.current = db.create();
	}

    public void interpretCommand(CommandTypes order) {
        if(order == CommandTypes.MOVE)   this.current = current.nextRoom(order.getCmd());
        //if(order == CommandTypes.USE)   this.current = current.nextRoom(order.getCmd());
        //if(order == CommandTypes.KILL)   this.current = current.nextRoom(order.getCmd());

    }

	public String getCurrentRoomName() {
		return this.current.getName();
	}

    public Room getCurrentRoom() {
        return this.current;
    }

    public boolean gameIsFinished() {
        return this.current.isFinished();
    }

    public boolean gameIsWon() { return true;}

    public boolean gameIsLost() { return false;}
}
