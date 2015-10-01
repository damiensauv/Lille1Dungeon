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
        Room middleRoom = dunToDisp.getCurrentRoom();
        System.out.print("|x|");
        if(middleRoom.isDirectionUsed("north")) System.out.print(" |");
        else                                    System.out.print("x|");
        System.out.print("x|\n");
        if(middleRoom.isDirectionUsed("west"))  System.out.print("| |");
        else                                    System.out.print("|x|");
        System.out.print("o|");
        if(middleRoom.isDirectionUsed("east"))  System.out.print(" |\n");
        else                                    System.out.print("x|\n");
        System.out.print("|x|");
        if(middleRoom.isDirectionUsed("south")) System.out.print(" |");
        else                                    System.out.print("x|");
        System.out.print("x|\n");
    }
}
