package lille1.dungeon.controller;

import lille1.dungeon.model.Dungeon;
import lille1.dungeon.model.Room;

import java.util.Scanner;

/**
 * Created by guilleminot on 24/09/15.
 */
public class ConsoleController implements Controller {

    public String askDirection() {
        Scanner scan = new Scanner(System.in);
        System.out.print("> ");
        return scan.nextLine();
    }
    public void notify(String spec) {
        System.out.println(spec);
    }

    @Override
    public void displayTray(Dungeon dunToDisp) {
        int east =0, north =0, west =0, south =0;
        Room middleRoom = dunToDisp.getCurrentRoom();

    }
}
