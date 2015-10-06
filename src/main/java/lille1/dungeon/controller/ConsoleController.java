package lille1.dungeon.controller;

import lille1.dungeon.model.commands.CommandTypes;
import lille1.dungeon.exceptions.*;

import java.util.Scanner;

/**
 * Created by guilleminot on 24/09/15.
 */
public class ConsoleController implements Controller {

    public CommandTypes openInput() throws CommandUnrecognizedException {
        Scanner scan = new Scanner(System.in);
        System.out.print("> ");
        CommandTypes commandType = null;

        String currentCommand = scan.nextLine();
        if (currentCommand.startsWith("go ")) commandType = CommandTypes.MOVE;
        if (currentCommand.startsWith("use ")) commandType = CommandTypes.USE;
        if (currentCommand.startsWith("hit ")) commandType = CommandTypes.KILL;

        if (commandType == null) throw new CommandUnrecognizedException();

        commandType.storeCmd(currentCommand);

        return commandType;

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

