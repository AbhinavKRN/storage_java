# Amazon Bestselling Books Dataset Analysis

This Java project analyzes Amazon's Top 50 bestselling books dataset from 2009 to 2019, containing information about 550 books with details such as title, author, user rating, reviews, price, year, and genre.

## Project Structure

The project consists of three main Java files:

1. **Book.java** - Defines the Book class with all necessary attributes and methods
2. **DatasetReader.java** - Handles reading and parsing the CSV dataset
3. **Driver.java** - Main application with interactive menu and all analysis tasks
4. **data.csv** - Dataset file (you can replace with your own dataset)

## Dataset Format

The CSV file should have the following columns:
- **Name**: Book title
- **Author**: Author's name
- **User Rating**: Average Amazon user rating (3.3 to 4.9)
- **Reviews**: Number of user reviews (37 to 87,800)
- **Price**: Book price in dollars ($0 to $105)
- **Year**: Year the book appeared on bestseller list (2009-2019)
- **Genre**: Book genre (Fiction or Non fiction)

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- The `data.csv` file in the same directory as the Java files

### Compilation
```bash
javac *.java
```

### Execution
```bash
java Driver
```

## Features and Tasks

The application provides an interactive menu with the following options:

### 1. Get Total Number of Books by an Author
- Input: Author name
- Output: Count of books written by that author
- Example: Enter "George R. R. Martin" to find how many books he has in the dataset

### 2. Print All Authors in the Dataset
- Output: Alphabetically sorted list of all unique authors
- Shows the total count of unique authors

### 3. Get Names of All Books by an Author
- Input: Author name
- Output: List of all book titles by that author
- Example: Enter "J.R.R. Tolkien" to see all his books

### 4. Classify Books by User Rating
- Input: Specific rating (e.g., 4.5)
- Output: All books with that exact rating
- Shows book title and author for each match

### 5. Get Prices of All Books by an Author
- Input: Author name
- Output: Book titles and their prices
- Example: Enter "George Orwell" to see prices of all his books

### 6. Print All Book Details
- Output: Complete details of all books in the dataset
- Shows title, author, rating, reviews, price, year, and genre

### 7. Exit
- Closes the application

## Sample Usage

```
Amazon Bestselling Books Dataset Analysis
========================================
Total books in dataset: 550

Choose an option:
1. Get total number of books by an author
2. Print all authors in the dataset
3. Get names of all books by an author
4. Classify books by user rating
5. Get prices of all books by an author
6. Print all book details
7. Exit
Enter your choice (1-7): 1
Enter author name: George R. R. Martin
Total books by George R. R. Martin: 4
```

## Data Validation

The application includes robust error handling for:
- Missing or malformed CSV files
- Invalid numeric values in the dataset
- CSV parsing with proper quote handling
- Case-insensitive author name matching

## Extending the Project

You can easily extend this project by:
- Adding more analysis methods to the Driver class
- Implementing data visualization features
- Adding database connectivity for larger datasets
- Creating statistical analysis functions (average ratings, price ranges, etc.)

## Notes

- The application uses case-insensitive matching for author names
- All numeric comparisons are exact (e.g., rating 4.5 will only match books with exactly 4.5 rating)
- The CSV parser handles quoted fields and commas within quotes properly
- The dataset includes 550 books from Amazon's bestselling list (2009-2019) 