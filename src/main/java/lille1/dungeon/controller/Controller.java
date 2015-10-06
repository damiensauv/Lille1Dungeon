package lille1.dungeon.controller;

import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.view.ConsoleDisplay;
import lille1.dungeon.view.Display;

/**
 * Created by Thotol on 30/09/2015.
 */
public interface Controller {

    public String askDirection();
    public void notify(String not);

    public static void main(String[] args) {
        Dungeon myDungeon = new Dungeon(Dungeon.GENERATION_TEST_KEY);
        Controller gameControl = new ConsoleController();
        Display gameDisplay = new ConsoleDisplay();
        do {
            gameDisplay.displayTray(myDungeon);
            gameControl.notify("You are in "+myDungeon.getCurrentRoom());
            gameControl.notify("Input direction :");
            myDungeon.interpretCommand(gameControl.askDirection());
        }
        while(!(myDungeon.gameIsFinished()));
    }
}
