import java.util.HashMap;

public class Library {

	private HashMap<String.Integer> books;
    
	private static Library library;
	  
	private Library() {}
  
	public static Library getInstance() {
		if (library == null) {
			System.out.println("Creating a library");
			library = new Library();
		}
		return library;
	}

	public boolean checkoutBook(String bookName) {
		
	}
 
	public void checkInBook(String bookName, int numToAdd) {
		
	}
 
	public void displaybooks() {
		
	}
  
	
}