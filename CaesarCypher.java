import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CaesarCypher {
    public static void main(String[] args) throws IOException {
        //Scanner cin = new Scanner(System.in);
        //System.out.println("1. Load from a file\n2. Enter a string to be encrypted");
        //String menu = cin.nextLine();

        Charset utf8 = StandardCharsets.UTF_8;
        List<String> list = Arrays.asList("Line 1", "Line 2");

        Files.write(Paths.get("app.log"), list, utf8);
        System.out.println(Paths.get("app.log"));
        Files.write(Paths.get("app.log"), list, utf8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.println(Files.readAllLines(Paths.get("app.log")));
        Files.write(Paths.get("app.log"), "Hello Word".getBytes(StandardCharsets.UTF_8));
        System.out.println(Files.readAllLines(Paths.get("app.log")));

        byte[] bytes = {1,2,3,4,5};
        Files.write(Paths.get("app.bin"), bytes);
        Files.write(Paths.get("app.log"), Arrays.asList("one","two","three"), utf8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.println(Files.readAllLines(Paths.get("app.log")));

    }

    int IntChoice() {
        Scanner cin = new Scanner(System.in);
        String ans = cin.nextLine();
        return 0;
    }
}
