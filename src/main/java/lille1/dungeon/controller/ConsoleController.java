package lille1.dungeon.controller;

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
    public String askDirection(String spec) {
        Scanner scan = new Scanner(System.in);
        System.out.print(spec +"\n> ");
        return scan.nextLine();
    }
}
