package lille1.dungeon.controller;

import lille1.dungeon.model.Dungeon;

/**
 * Created by Thotol on 30/09/2015.
 */
public interface Controller {

    public String askDirection();
    public String askDirection(String spec);

    public static void main(String[] args) {
        Dungeon myDungeon = new Dungeon();
        Controller gameControl = new ConsoleController();
        do {
            myDungeon.interpretCommand(gameControl.askDirection());
        }
        while(!(myDungeon.gameIsFinished()));
    }
}
