import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q3 {
//LogFilter
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter server log file path: ");
        String logFilePath = scanner.nextLine();
        String outputFile = "error_logs.txt";

        long errorCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ERROR")) {
                    writer.write(line);
                    writer.newLine();
                    errorCount++;
                }
            }
            System.out.println("Processing completed successfully.");
            System.out.println("Total 'ERROR' lines found and written to " + outputFile + ": " + errorCount);
        } catch (IOException e) {
            System.err.println("Error handling log file: " + e.getMessage());
        }
    }
}