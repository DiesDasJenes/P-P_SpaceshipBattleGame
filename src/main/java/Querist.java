import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Querist {
    private final Scanner scanner;
    private final PrintStream out;

    Querist(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public Object ask(String message) {
        out.println(message);
        return scanner.next();
    }
}
