package lille1.dungeon.controller;

import lille1.dungeon.exceptions.*;
import lille1.dungeon.model.action.Action;
import lille1.dungeon.model.action.Go;
import lille1.dungeon.model.action.Hit;
import lille1.dungeon.model.action.Use;
import lille1.dungeon.utils.JavaScanner;
import lille1.dungeon.utils.Scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilleminot on 24/09/15.
 */
public class ConsoleController extends BaseController {

    Scanner scan;

    private void init(Scanner scanner) {
        this.scan = scanner;
    }

    public ConsoleController() {
        init(new JavaScanner());
    }

    public ConsoleController(Scanner mockScanner) {
        init(mockScanner);
    }

    public Action openInput() throws CommandUnrecognizedException {
        System.out.println("Possible commands 'go X' 'hit' 'use ITEMS' ");
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
        System.out.print("> ");
        return scan.nextLine();

    }
}

