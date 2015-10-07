package lille1.dungeon.tests;

/**
 * Created by nanosvir on 07 Oct 15.
 */
public class MockScanner extends lille1.dungeon.utils.Scanner {

    private String next;

    @Override
    public String nextLine() {
        if (next != null) {
            String tmp = next;
            next = null;
            return tmp;
        }
        return null;
    }

    public String next(String string) {
        return this.next = string;
    }
}
