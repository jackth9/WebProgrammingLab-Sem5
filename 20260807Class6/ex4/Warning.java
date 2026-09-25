import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Warning {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter input file path: ");
        String inputFileName = keyboard.nextLine();
        System.out.print("Enter output file path: ");
        String outputFileName = keyboard.nextLine();

        try {
            Scanner scan = new Scanner(new File(inputFileName));
            PrintWriter outFile = new PrintWriter(new FileWriter(outputFileName));

            while (scan.hasNext()) {
                String name = scan.next();
                int hours = Integer.parseInt(scan.next());
                double qualityPoints = Double.parseDouble(scan.next());

                double gpa = qualityPoints / hours;

                if ((hours < 30 && gpa < 1.5) || (hours < 60 && gpa < 1.75) || (hours >= 60 && gpa < 2.0)) {
                    outFile.println(name + " " + hours + " " + gpa);
                }
            }

            outFile.close();
            scan.close();
            System.out.println("Processing complete.");
        } catch (FileNotFoundException e) {
            System.out.println("File Error: The specified file could not be found - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Data Error: Unable to parse credit hours or quality points - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: An issue occurred while reading/writing files - " + e.getMessage());
        } finally {
            keyboard.close();
        }
    }
}