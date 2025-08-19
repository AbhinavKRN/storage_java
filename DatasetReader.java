import java.io.*;
import java.util.*;

public class DatasetReader {
    
    public static List<Book> readDataset(String filename) {
        List<Book> books = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                Book book = parseBookLine(line);
                if (book != null) {
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return books;
    }
    
    private static Book parseBookLine(String line) {
        try {
            String[] parts = parseCSVLine(line);
            
            if (parts.length >= 7) {
                String title = parts[0].trim().replaceAll("^\"|\"$", "");
                String author = parts[1].trim().replaceAll("^\"|\"$", "");
                double userRating = Double.parseDouble(parts[2].trim());
                int reviews = Integer.parseInt(parts[3].trim());
                double price = Double.parseDouble(parts[4].trim());
                int year = Integer.parseInt(parts[5].trim());
                String genre = parts[6].trim().replaceAll("^\"|\"$", "");
                
                return new Book(title, author, userRating, reviews, price, year, genre);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric values in line: " + line);
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line + " - " + e.getMessage());
        }
        
        return null;
    }
    
    private static String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(current.toString());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        
        result.add(current.toString());
        return result.toArray(new String[0]);
    }
} 