package lille1.dungeon.controller;

import lille1.dungeon.model.Dungeon;

/**
 * Created by Thotol on 30/09/2015.
 */
public interface Controller {

    public String askDirection();
    public void notify(String not);

    public static void main(String[] args) {
        Dungeon myDungeon = new Dungeon(9001);
        Controller gameControl = new ConsoleController();
        do {
            gameControl.notify("You are in "+myDungeon.getCurrentRoom());
            gameControl.notify("Input direction :");
            myDungeon.interpretCommand(gameControl.askDirection());
        }
        while(!(myDungeon.gameIsFinished()));
    }
}
