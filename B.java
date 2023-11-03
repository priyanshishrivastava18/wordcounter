import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class  B{
    public static void main(String[] args) {
        String filePath = "your_text_file.txt";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
            reader.close();

            String[] words = text.toString().split("\\s+");

            // Count the total number of words
            int wordCount = words.length;
            System.out.println("Total number of words: " + wordCount);

            // Calculate the average word length
            int totalWordLength = 0;
            for (String word : words) {
                totalWordLength += word.length();
            }
            double averageWordLength = (double) totalWordLength / wordCount;
            System.out.println("Average word length: " + averageWordLength);

            // Calculate word frequency
            Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                word = word.toLowerCase(); // Convert to lowercase to make it case-insensitive
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            // Display word frequency
            System.out.println("Word frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}