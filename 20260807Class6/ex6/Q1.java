import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Q1 {
//WordFrequencyByteStream
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input file path: ");
        String inputPath = scanner.nextLine();
        System.out.print("Enter output file path: ");
        String outputPath = scanner.nextLine();

        StringBuilder content = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(inputPath)) {
            int b;
            while ((b = fis.read()) != -1) {
                content.append((char) b);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        String[] words = content.toString().toLowerCase().split("[^a-zA-Z0-9]+");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> alphabeticalList = new ArrayList<>(freqMap.entrySet());
        alphabeticalList.sort(Map.Entry.comparingByKey());

        List<Map.Entry<String, Integer>> frequencyList = new ArrayList<>(freqMap.entrySet());
        frequencyList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        StringBuilder output = new StringBuilder();
        output.append("=== WORDS IN ALPHABETICAL ORDER ===\n");
        for (Map.Entry<String, Integer> entry : alphabeticalList) {
            output.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        output.append("\n=== WORDS SORTED BY FREQUENCY (MOST FREQUENT FIRST) ===\n");
        for (Map.Entry<String, Integer> entry : frequencyList) {
            output.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(output.toString().getBytes());
            System.out.println("Processing complete. Results written to " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}