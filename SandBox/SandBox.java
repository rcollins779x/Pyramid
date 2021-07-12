package SandBox;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class SandBox {
    public static ArrayList<Integer> solution(ArrayList<Integer> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (nums.size() == 0) return null;
        else {
            int max = nums.get(0), start = 0, end = 0, sum = 0, counter = 0;

            for ( int k = 0; k < nums.size(); k++) { //Range of cells to sum
                System.out.println("i\tj\tsum\tmax\trange");
                for (int i = 0, j = k; j < nums.size(); i++, j++, sum = 0) { //Sums starting at index i until index j
                    for (int l = i; l < j+1; l++, counter++) sum += nums.get(l);
                    if(max < sum) {
                        max = sum;
                        start = i;
                        end = j;
                    }
                    System.out.println(i + "\t" + j + "\t" + sum + "\t" + max + "\t" + start + "-" + end);
                }
            }
            System.out.println(counter);
            return new ArrayList<>(nums.subList(start,end+1));
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>() {{ add(-15); add(42); add(-48); add(50); add(23); add(43); add(27); add(-25); add(9); add(-30); add(-37); add(7); add(-33); add(27); add(4); }};
        HashSet<Integer> map = new HashSet<>() {{ add(0); add(3); add(4); }};
        int[] A = { 1, 2, 3, 4, 5 };
        int sum = Arrays.stream(A).reduce(0, (x, y) -> x + y);

        String[] ans = new String[2];
        ArrayList<String> buffer = new ArrayList<>();
        Path texts = Path.of("C:\\IntelliJUltimate\\pyramid-curriculum-2.0\\src\\assignments\\section8\\texts.csv");
        Path calls = Path.of("C:\\IntelliJUltimate\\pyramid-curriculum-2.0\\src\\assignments\\section8\\calls.csv");
        String[] text = ReadAFile(texts).get(0).split(",");
        String[] call = (buffer = ReadAFile(calls)).get(buffer.size()-1).split(",");
        ans[0] = "First record of texts, " + text[0] + " texts " + text[1] + " at time " + text[2];
        ans[1] = "First record of texts, " + call[0] + " texts " + call[1] + " at time " + call[2];

/*
        Files.lines(texts).filter(c -> !c.contains("2")).forEach(buffer::add);
        System.out.println(buffer);
        System.out.println(ans[0]);

        ans[1] = (buffer = ReadAFile(calls)).get(buffer.size()-1);
        System.out.println(ans[1]);

*/


        //Scanner cin = new Scanner(System.in);
        //System.out.println("1. Load from a file\n2. Enter a string to be encrypted");
        //String menu = cin.nextLine();

        //FileSystem fs = FileSystems.getDefault();
        //fs.getFileStores().forEach(s-> System.out.println(s.type() + ' ' + s.name()));
        //fs.getRootDirectories().forEach(p-> System.out.println(p));
        //String separator = fs.getSeparator();
        //System.out.println(separator);
        //Path file = Path.of("C:\\IntelliJUltimate\\pyramid-curriculum-2.0\\resources\\sample_data.txt");
        //Files.deleteIfExists(file);
        //Files.createFile(file);
        //System.out.println(file.toAbsolutePath());
        //System.out.println(file.toAbsolutePath().getParent());
        //System.out.println(file.toAbsolutePath().getParent().getParent());
        //System.out.println(file.getRoot() + " " + file.getParent());
        //Charset utf8 = StandardCharsets.UTF_8;
        //List<String> list2 = Arrays.asList("test");
        //Path plain = Paths.get("ClearText.txt");
        //Path grade = Paths.get("Grade.txt");
        //Path encrypted = Paths.get("Encrypted.txt");
        //Files.write(file, list2, utf8);

        //System.out.println(encrypted);
        //Files.write(grade, list, utf8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        //List<String> buffer = Files.readAllLines(plain);
        //System.out.println(buffer);
        //List<String> buffer = Files.readAllLines(grade);
        //System.out.println(buffer);
        //ReadAFile(file);
        //Files.write(Paths.get("app.log"), "Hello Word".getBytes(StandardCharsets.UTF_8));

        //ArrayList<String>file2 = Files.readAllLines(Paths.get)
    }
    static char CharChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for(temp = cin.nextLine(); temp.length() != 1; temp = cin.nextLine())
            System.out.println("Please try again. That is not a valid string.\n");
        return temp.charAt(0) > 96 ? (char) (temp.charAt(0) - 32) : temp.charAt(0);
    }
    int IntChoice() {
        Scanner cin = new Scanner(System.in);
        String ans = cin.nextLine();
        return 0;
    }
    static ArrayList<String> ReadAFile(Path file) throws IOException {
        ArrayList<String> buffer = new ArrayList<>();
        if (Files.isReadable(file))
            Files.lines(file).forEach(buffer::add);
        return buffer;
    }
}
