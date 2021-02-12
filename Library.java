
import java.util.HashMap;
/**
 * Library class to store books and keep track of the number of copies
 * Uses a Hashmap with the bookname as the Key and the number of copiess as the Vale
 * @author ddkeen
 */
public class Library {

    private HashMap<String, Integer> books;
    private static Library library;
      
    /**
     * Creates a new Hashmap of all the book titles and names to serve as the library's inventory
     */
    private Library() {
        books = new HashMap<String, Integer>();
    }
  
    /**
     * static method that creates a new library if there isn't one in existence already
     * this method ensures only one instance of a library is ever made
     * @return  library, the old library if there was already or a new one
     */
    public static Library getInstance() {
	    if (library == null) {
		    System.out.println("Creatng our Library. Time to begin reading.");
		    library = new Library();
		}
	    return library;
    }

    /**
     * Check out a book from the library
     * @param bookName the name of the book attempted to be checked out
     * @return boolean true if the book is in the library and able to be checked out, false otherwise
     */
    public boolean checkoutBook(String bookName) {
        if(books.containsKey(bookName) && books.get(bookName) > 0)
        {
            books.put(bookName, books.get(bookName) - 1);
            System.out.println(bookName + " was successfully checked out");
            return true;
        }
        System.out.println("Sorry " + bookName + " is not in stock");
        return false;
    }
 
    /**
     * Return a book to the library or add a new book
     * @param bookName the name of the book being checked in
     * @param numToAdd the number of copies of this book being added to the library 
     */
    public void checkInBook(String bookName, int numToAdd) {
        if(books.containsKey(bookName)) {
            books.put(bookName, books.get(bookName) + numToAdd);
            System.out.println("A new copy of " + bookName + " was added to the library");
        }
        else {
            books.put(bookName, numToAdd);
            System.out.println(bookName + " was added to the library");
        }
    }
 
    /**
     * Display all contents of the library, including the name and number of copies of each book, even if there are no copies left.
     */
    public void displayBooks() {
        System.out.println("\nInventory:");
        for (HashMap.Entry book : books.entrySet()) {
            System.out.println("- "  + book.getKey() + ", copies: " + book.getValue());
        }
    }
  
}