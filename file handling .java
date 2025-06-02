package FileHandling;

import java.io.*;
import java.util.Scanner;

public class File01 {
    public static void main(String[] args) {
        String inputFileName = "Sample.txt";
        String outputFileName = "New Sample.txt";

        try (
            Scanner scanner = new Scanner(System.in);
            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFileName, true)); // append mode
        ) {
            System.out.println("Enter text (type 'exit' to finish):");

            // Multi-line input
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }

            writer.flush(); // Flush to make sure everything is written
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }

        // Copy content from Sample.txt to New Sample.txt
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFileName))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                outputWriter.write(line);
                outputWriter.newLine();
            }

            System.out.println("Text successfully copied to " + outputFileName);
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
