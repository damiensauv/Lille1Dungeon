package lille1.dungeon.controller;

import lille1.dungeon.exceptions.*;
import lille1.dungeon.model.action.Action;
import lille1.dungeon.model.action.Go;
import lille1.dungeon.model.action.Hit;

import java.util.Scanner;

/**
 * Created by guilleminot on 24/09/15.
 */
public class ConsoleController extends BaseController {

    Action[] actions = {
            new Go(),
            new Hit()
    };

    public Action openInput() throws CommandUnrecognizedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Possible commands 'go X' 'hit' ");
        System.out.print("> ");
        Action result = null;
        String line = scan.nextLine();
        for (Action action: this.actions) {
            if ((result = action.interpretCommand(line)) != null) {
                break;
            }
        }
        if (result == null) throw new CommandUnrecognizedException();
        return result;

    }

    public void notify(String spec) {
        System.out.println(spec);
    }

    public String getText() {
        Scanner scan = new Scanner(System.in);
        System.out.print("> ");

        String currentCommand = scan.nextLine();

        return currentCommand;

    }
}

