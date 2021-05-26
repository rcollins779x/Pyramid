package CaesarCypher;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class CaesarCypher {
    public static void main(String[] args) { menu(); }

    private static void menu() {
        ArrayList<String> buffer = new ArrayList<>(), newBuffer = new ArrayList<>();

        for(int choice = 1, load; choice != 0;) {
            do {
                System.out.println("0. Exit\n1. Enter a message\n2. Load a file" + (buffer.size() != 0 ?
                        "\n3. Shift current message" : "") + (newBuffer.size() != 0 ? "\n4. Save Shifted message to a file" : ""));
                choice = IntChoice();
                System.out.print((choice < 0 || choice > 4 ? "I don't understand. Please try again.\n" : ""));
            } while (choice < 0 || choice > 4);

            switch (choice) {
                case 1:
                    System.out.print("Only alphabetic characters will be shifted.\n Enter message: ");
                    buffer.add(StringChoice());
                    System.out.println(buffer);
                    break;
                case 2:
                    System.out.println("0. Return to main menu\n1. Load input.txt\n2. Load output.txt");
                    do {
                        load = IntChoice();
                        if(load < 0 || load > 2) System.out.println("I don't understand. Please try again.");
                    } while (load < 0 || load > 2);
                    if( load == 0) break;

                    Path file = Paths.get("src", "CaesarCypher", load == 1 ? "input.txt" : "output.txt");
                    System.out.println(("Path: " + file.toAbsolutePath()));
                    try { buffer = ReadAFile(file); } catch (IOException ignore) {}
                    finally {
                        if (buffer.size() == 0) System.out.println("File not Found!");
                        else System.out.println(buffer);
                    }
                    break;
                case 3:
                    newBuffer = encrypt(buffer);
                    break;
                case 4:
                    try {
                        Path output = Paths.get("src", "CaesarCypher", "output.txt");
                        Files.deleteIfExists(output);
                        Files.write(output, newBuffer, StandardOpenOption.CREATE);
                        System.out.println(("Path: " + output.toAbsolutePath()));
                    } catch (IOException ignore) {
                        System.out.println("Failed to write to file.");
                    }
                    break;
            }
        }
    }

    private static ArrayList<String> encrypt(ArrayList<String> buffer) {
        ArrayList<String> newBuffer = new ArrayList<>();
        String line = "";

        System.out.println("Enter shift amount");
        int shift = IntChoice();

        shift %= 26;
        for(int i = 0; i < buffer.size(); i++, newBuffer.add(line), line = "")
            for (int j = 0; j < buffer.get(i).length(); j++) {
                int temp = buffer.get(i).charAt(j);

                if (temp > 64 && temp < 91 || (temp > 96 && temp < 123)) {
                    if (temp < 91 && temp + shift > 90) temp += 6;
                    if (temp + shift > 122) temp -= 58;
                    if (temp + shift < 65) temp += 58;
                    if (temp > 96 && temp + shift < 97) temp -= 6;
                    line += (char) (temp + shift);
                } else line += (char) temp;
            }
        System.out.println("Input : " + buffer);
        System.out.println("Output: " + newBuffer);
        return newBuffer;
    }

    static boolean isInt(String value) {
        String temp = (value.charAt(0) == '-') ? value.substring(1) : value;
        for(int i = 0; i < temp.length(); i++)
            if(!isDigit(temp.charAt(i))) return true;
        return temp.length() == 0;
    }

    static int IntChoice() {
        Scanner cin = new Scanner(System.in);
        String temp;
        for(temp = cin.nextLine(); isInt(temp);temp = cin.nextLine())
            if(isInt(temp)) System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return Integer.parseInt(temp);
    }
    static String StringChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for(temp = cin.nextLine();temp.length() == 0;temp = cin.nextLine())
            System.out.println("Please try again. That is not a valid string.\n");
        return temp;
    }
    static ArrayList<String> ReadAFile(Path file) throws IOException {
        ArrayList<String> buffer = new ArrayList<>();
        if(Files.isReadable(file))
            Files.lines(file).forEach(buffer::add);
        return buffer;
    }
}
