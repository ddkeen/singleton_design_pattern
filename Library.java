import java.util.HashMap;
public class Library {

	private HashMap<String, Integer> books;
	private static Library library;
	  
	private Library() {
        books = new HashMap<String, Integer>();
    }
  
	public static Library getInstance() {
		if (library == null) {
			System.out.println("Creatng our Library. Time to begin reading.");
			library = new Library();
		}
		return library;
	}

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
 
	public void displayBooks() {
        System.out.println("\nInventory:");
		for (HashMap.Entry book : books.entrySet()) {
            System.out.println("- "  + book.getKey() + ", copies: " + book.getValue());
        }
	}
  
}