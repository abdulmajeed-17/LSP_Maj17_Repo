package org.howard.edu.lsp.midterm.question1;

/**
 * Represents a book in the library system.
 */
public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String isbn;
    private int publicationYear;

    /**
     * Initializes a new Book with the specified details.
     *
     * @param bookTitle       The title of the book.
     * @param bookAuthor      The author of the book.
     * @param isbn            The ISBN number of the book.
     * @param publicationYear The year the book was published.
     * @throws IllegalArgumentException if any parameter is invalid.
     */
    public Book(String bookTitle, String bookAuthor, String isbn, int publicationYear) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty.");
        }
        if (bookAuthor == null || bookAuthor.trim().isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be empty.");
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty.");
        }
        if (publicationYear < 0) {
            throw new IllegalArgumentException("Publication year cannot be negative.");
        }

        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    // Getters and Setters

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty.");
        }
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        if (bookAuthor == null || bookAuthor.trim().isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be empty.");
        }
        this.bookAuthor = bookAuthor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty.");
        }
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear < 0) {
            throw new IllegalArgumentException("Publication year cannot be negative.");
        }
        this.publicationYear = publicationYear;
    }

    /**
     * Checks if this book is equal to another object based on ISBN and author.
     *
     * @param obj The object to compare.
     * @return true if both books have the same ISBN and author; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book otherBook = (Book) obj;
        return isbn.equals(otherBook.isbn) && bookAuthor.equals(otherBook.bookAuthor);
    }

    /**
     * Generates a hash code based on ISBN and author.
     *
     * @return The hash code of the book.
     */
    @Override
    public int hashCode() {
        int result = isbn.hashCode();
        result = 31 * result + bookAuthor.hashCode();
        return result;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return A formatted string with book details.
     */
    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, ISBN: %s, Year Published: %d",
                bookTitle, bookAuthor, isbn, publicationYear);
    }
}
