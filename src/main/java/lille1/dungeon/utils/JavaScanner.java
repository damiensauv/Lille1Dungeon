package lille1.dungeon.utils;

/**
 * Created by nanosvir on 07 Oct 15.
 */
public class JavaScanner extends Scanner {

    java.util.Scanner scanner;

    public JavaScanner() {
        this.scanner = new java.util.Scanner(System.in);
    }

    /**
     * Scan the next line with java.util.Scanner.nextLine()
     * @return the next line
     */
    @Override
    public String nextLine() {
        return this.scanner.nextLine();
    }
}
