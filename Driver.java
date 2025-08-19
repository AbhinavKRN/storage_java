import java.util.*;

public class Driver {
    
    public static void main(String[] args) {
        List<Book> books = DatasetReader.readDataset("data.csv");
        
        if (books.isEmpty()) {
            System.out.println("No books found in the dataset. Please check if data.csv exists.");
            return;
        }
        
        System.out.println("Amazon Bestselling Books Dataset Analysis");
        System.out.println("========================================");
        System.out.println("Total books in dataset: " + books.size());
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Get total number of books by an author");
            System.out.println("2. Print all authors in the dataset");
            System.out.println("3. Get names of all books by an author");
            System.out.println("4. Classify books by user rating");
            System.out.println("5. Get prices of all books by an author");
            System.out.println("6. Print all book details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter author name: ");
                    String author1 = scanner.nextLine();
                    int count = getTotalBooksByAuthor(books, author1);
                    System.out.println("Total books by " + author1 + ": " + count);
                    break;
                    
                case 2:
                    printAllAuthors(books);
                    break;
                    
                case 3:
                    System.out.print("Enter author name: ");
                    String author2 = scanner.nextLine();
                    List<String> bookNames = getBooksByAuthor(books, author2);
                    if (bookNames.isEmpty()) {
                        System.out.println("No books found for author: " + author2);
                    } else {
                        System.out.println("Books by " + author2 + ":");
                        for (String bookName : bookNames) {
                            System.out.println("- " + bookName);
                        }
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter user rating (e.g., 4.5): ");
                    double rating = scanner.nextDouble();
                    List<Book> booksWithRating = getBooksByRating(books, rating);
                    if (booksWithRating.isEmpty()) {
                        System.out.println("No books found with rating: " + rating);
                    } else {
                        System.out.println("Books with rating " + rating + ":");
                        for (Book book : booksWithRating) {
                            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
                        }
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter author name: ");
                    String author3 = scanner.nextLine();
                    printBooksAndPricesByAuthor(books, author3);
                    break;
                    
                case 6:
                    System.out.println("All book details:");
                    for (Book book : books) {
                        book.printDetails();
                    }
                    break;
                    
                case 7:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static int getTotalBooksByAuthor(List<Book> books, String author) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }
    
    public static void printAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        
        System.out.println("All authors in the dataset (" + authors.size() + " unique authors):");
        List<String> sortedAuthors = new ArrayList<>(authors);
        Collections.sort(sortedAuthors);
        for (String author : sortedAuthors) {
            System.out.println("- " + author);
        }
    }
    
    public static List<String> getBooksByAuthor(List<Book> books, String author) {
        List<String> bookNames = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                bookNames.add(book.getTitle());
            }
        }
        return bookNames;
    }
    
    public static List<Book> getBooksByRating(List<Book> books, double rating) {
        List<Book> booksWithRating = new ArrayList<>();
        for (Book book : books) {
            if (book.getUserRating() == rating) {
                booksWithRating.add(book);
            }
        }
        return booksWithRating;
    }
    
    public static void printBooksAndPricesByAuthor(List<Book> books, String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorBooks.add(book);
            }
        }
        
        if (authorBooks.isEmpty()) {
            System.out.println("No books found for author: " + author);
        } else {
            System.out.println("Books and prices by " + author + ":");
            for (Book book : authorBooks) {
                System.out.println("- " + book.getTitle() + ": $" + book.getPrice());
            }
        }
    }
} 