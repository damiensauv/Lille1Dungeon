package lille1.dungeon.utils;

/**
 * Created by nanosvir on 07 Oct 15.
 */
public class JavaScanner extends Scanner {

    java.util.Scanner scanner;

    public JavaScanner() {
        this.scanner = new java.util.Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return this.scanner.nextLine();
    }
}
