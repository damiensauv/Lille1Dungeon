package lille1.dungeon.controller;

import lille1.dungeon.exceptions.CommandUnrecognizedException;
import lille1.dungeon.exceptions.InvalidActionException;
import lille1.dungeon.model.action.Go;
import lille1.dungeon.model.action.Hit;
import lille1.dungeon.model.action.Use;
import lille1.dungeon.model.chars.Hero;
import lille1.dungeon.model.action.Action;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.view.ConsoleDisplay;
import lille1.dungeon.view.Display;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public abstract class BaseController implements Controller {

    List<Action> actions = new ArrayList<>();

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public void addDefaultActions() {
        this.addAction(Go.Instance);
        this.addAction(Hit.Instance);
        this.addAction(Use.Instance);
    }

    public static void main(String[] args) {
        BaseController gameControl = new ConsoleController();
        gameControl.addDefaultActions();
        Display gameDisplay = new ConsoleDisplay();

        gameControl.notify("Choose your char Name");
        Hero ken = new Hero(gameControl.getText());

        Dungeon myDungeon = new Dungeon(Dungeon.GENERATION_TEST_KEY, ken);
        do {
            gameDisplay.displayTray(myDungeon);
            gameControl.notify("You are in " + myDungeon.getCurrentRoom());
            gameControl.notify("My life " + myDungeon.getHero().getLife());
            gameControl.notify("Input direction :");
            try {
                Action action = gameControl.openInput();
                gameControl.notify(action.apply(myDungeon));
            } catch (CommandUnrecognizedException e) {
                gameControl.notify("Wrong input");
            } catch (InvalidActionException e) {
                gameControl.notify(e.getMessage());
            }
        }
        while (!(myDungeon.gameIsFinished()));
        if (myDungeon.gameIsWon()) gameControl.notify("Congratulation ! You just won !");
        if (myDungeon.gameIsLost()) gameControl.notify("Errrr ! You just lost!");
    }

}
