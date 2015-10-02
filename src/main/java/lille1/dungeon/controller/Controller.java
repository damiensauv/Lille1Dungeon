package lille1.dungeon.controller;

import lille1.dungeon.model.Dungeon;

/**
 * Created by Thotol on 30/09/2015.
 */
public interface Controller {

    public String askDirection();
    public void notify(String not);
    public void displayTray(Dungeon dunToDisp);

    public static void main(String[] args) {
        Dungeon myDungeon = new Dungeon(Dungeon.GENERATION_TEST_KEY);
        Controller gameControl = new ConsoleController();
        do {
            gameControl.displayTray(myDungeon);
            gameControl.notify("You are in "+myDungeon.getCurrentRoom());
            gameControl.notify("Input direction :");
            myDungeon.interpretCommand(gameControl.askDirection());
        }
        while(!(myDungeon.gameIsFinished()));
    }
}
