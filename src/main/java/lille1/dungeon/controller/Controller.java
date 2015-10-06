package lille1.dungeon.controller;

import lille1.dungeon.exceptions.CommandUnrecognizedException;
import lille1.dungeon.exceptions.MonsterNotDeadException;
import lille1.dungeon.exceptions.RoomIsNotAMonsterRoomException;
import lille1.dungeon.model.chars.Hero;
import lille1.dungeon.model.commands.CommandTypes;
import lille1.dungeon.model.tray.Dungeon;
import lille1.dungeon.model.tray.MonsterRoom;
import lille1.dungeon.view.ConsoleDisplay;
import lille1.dungeon.view.Display;

/**
 * Created by Thotol on 30/09/2015.
 */
public interface Controller {

    CommandTypes openInput() throws CommandUnrecognizedException;

    void notify(String not);

    static void main(String[] args) {
        Controller gameControl = new ConsoleController();
        Display gameDisplay = new ConsoleDisplay();

        gameControl.notify("Choose your char Name");
        Hero ken = new Hero(gameControl.getText());

        Dungeon myDungeon = new Dungeon(Dungeon.GENERATION_TEST_KEY, ken);
        do {
            gameDisplay.displayTray(myDungeon);
            gameControl.notify("You are in " + myDungeon.getCurrentRoom());
            gameControl.notify("My life " + myDungeon.getHero().getLife());
            gameControl.notify("Input direction :");
            CommandTypes ct;
            try {
                ct = gameControl.openInput();
                try {
                    myDungeon.interpretCommand(ct);
                } catch (MonsterNotDeadException e) {
                    gameControl.notify("You have to kill the monster !");
                } catch (RoomIsNotAMonsterRoomException e) {
                    gameControl.notify("There is no monster to kill you dumbass !");
                }

            } catch (CommandUnrecognizedException e) {
                gameControl.notify("Wrong input :");
            }
            if (myDungeon.getCurrentRoom() instanceof MonsterRoom) {
                MonsterRoom mr = (MonsterRoom) myDungeon.getCurrentRoom();
                if(mr.getMonster()!=null) mr.getMonster().hit(myDungeon.getHero());
            }
        }
        while (!(myDungeon.gameIsFinished()));
        if (myDungeon.gameIsWon()) gameControl.notify("Congratulation ! You just won !");
        if (myDungeon.gameIsLost()) gameControl.notify("Errrr ! You just lost!");
    }

    String getText();
}
