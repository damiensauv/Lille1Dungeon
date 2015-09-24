package lille1.dungeon.controller;

import lille1.dungeon.model.Dungeon;

import java.util.Scanner;

/**
 * Created by guilleminot on 24/09/15.
 */
public class ConsoleController {

    public static void main(String[] args) {
        Dungeon myDungeon = new Dungeon();
        Scanner scan = new Scanner(System.in);
        do {
            myDungeon.interpretCommand(scan.nextLine());
        }
        while(!(myDungeon.gameIsFinished()));
    }
}
