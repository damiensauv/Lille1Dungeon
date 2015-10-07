package lille1.dungeon.utils;

import lille1.dungeon.exceptions.InvalidCommand;

/**
 * Created by nsvir on 06/10/15.
 * n.svirchevsky@gmail.com
 */
public class Parser {

    /**
     * check if the prefix is prefix of the line
     *
     * @param prefix the prefix
     * @param line   the line
     * @return <code>true</code> if prefix is prefix of line
     */
    public static boolean isPrefix(String prefix, String line) {
        line = cleanString(line);
        int i = line.indexOf(' ');
        return (i != -1 && prefix.equals(line.substring(0, i)))
                || prefix.equals(line);
    }

    /**
     * get the post command (in the cased there is a prefix)
     * @param line the user input
     * @return the post command
     * @exception InvalidCommand if no post command exists
     */
    public static String getPostCommand(String line) throws InvalidCommand {
        line = cleanString(line);
        int i = line.indexOf(' ');
        if (i == -1) {
            throw new InvalidCommand();
        }
        return line.substring(i + 1);
    }

    /**
     * clean the received string with multiple space / tabulation with only a space
     * @param line the line to clean
     * @return the cleaned line
     */
    public static String cleanString(String line) {
        line = line.replaceAll("[ \\t]+", " ");
        return line.replaceAll("^[ \\t]|[ \\t]$", "");
    }
}
