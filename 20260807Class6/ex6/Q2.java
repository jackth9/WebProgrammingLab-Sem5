import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q2 {
//Upper case converter
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source file path: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Enter destination file path: ");
        String destPath = scanner.nextLine();

        try (FileReader reader = new FileReader(sourcePath);
             FileWriter writer = new FileWriter(destPath)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toUpperCase((char) ch));
            }
            System.out.println("File copied and converted to uppercase successfully.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}