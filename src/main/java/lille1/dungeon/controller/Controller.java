package lille1.dungeon.controller;

import lille1.dungeon.model.commands.CommandTypes;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.view.ConsoleDisplay;
import lille1.dungeon.view.Display;

/**
 * Created by Thotol on 30/09/2015.
 */
public interface Controller {

    public CommandTypes openInput() throws ConsoleController.CommandUnrecognizedException;
    public void notify(String not);

    public static void main(String[] args) {
        Dungeon myDungeon = new Dungeon(Dungeon.GENERATION_TEST_KEY);
        Controller gameControl = new ConsoleController();
        Display gameDisplay = new ConsoleDisplay();
        do {
            gameDisplay.displayTray(myDungeon);
            gameControl.notify("You are in "+myDungeon.getCurrentRoom());
            gameControl.notify("Input direction :");
            CommandTypes ct;
            try {
                ct = gameControl.openInput();
                myDungeon.interpretCommand(ct);
            } catch (ConsoleController.CommandUnrecognizedException e) {
                gameControl.notify("Wrong input :");
            }
        }
        while(!(myDungeon.gameIsFinished()));
        if(myDungeon.gameIsWon()) gameControl.notify("Congratulation ! You just won !");
        if(myDungeon.gameIsLost()) gameControl.notify("Errrr ! You just lost!");
    }
}
