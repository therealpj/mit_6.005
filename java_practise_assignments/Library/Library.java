import java.util.ArrayList;

public class Library {
    String address;
    ArrayList<Book> books;

    public Library(String address) {
        this.address = address;
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public static void printOpeningHours() {
        System.out.println("Opening time: 9 A.M.");
        System.out.println("Closing time: 10 P.M.");
    }

    public void printAddress() {
        System.out.println(address);
    }

    public void borrowBook(String book) {
        int bookIndex = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equals(book)) {
                bookIndex = i;
            }
        }

        if ( bookIndex == -1) {
            System.err.println("No such book currently present in library");
            return;
        }

        if (books.get(bookIndex).isBorrowed()) {
            System.err.println("Sorry, this book is currently borrowed");
            return;
        }

        books.get(bookIndex).borrowed();
        System.out.println("Book successfully borrowed");
    }

    public void printAvailableBooks() {
        if (books.size() == 0) {
            System.err.println("Our library is undergoing changes. We don't have any books at the moment.");
        }
        for (Book b : books) {
            if (!b.isBorrowed())
                System.out.println(b.title);
        }
    }

    public void returnBook(String book) {
        int bookIndex = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equals(book)) {
                bookIndex = i;
            }
        }
        books.get(bookIndex).returned();
        System.out.println("Book returned succesfully");
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
