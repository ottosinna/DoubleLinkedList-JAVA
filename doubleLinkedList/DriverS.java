// step 1
import java.util.Scanner; // used to read input from user via keyboard

class DriverS {

	public static void main(String[] args) {
	
		// step 2
		Scanner sc = new Scanner(System.in);
		DoubleLinkedList<Book> books = new DoubleLinkedList<Book>();
		
		System.out.print("Enter number of books: " );
		String numberOfBooksStr = sc.nextLine();
		int numberOfBooks = Integer.parseInt(numberOfBooksStr);
		
		print("numberOfBooksStr: " + numberOfBooksStr);
		print("numberOfBooks: " + numberOfBooks);
		Book[] bookNum = new Book[numberOfBooks];

		// Book book1= new Book("dogs", 61111);
		
		//printing list
		print("\nDouble Linked List: ");
		books.print();

		//books intialize
		for(int i = 0; i < numberOfBooks; i++) {
			System.out.print("Enter name of books: ");
			String name = sc.nextLine();
			System.out.print("Enter ISBN of books: ");
			int ISBN = Integer.parseInt(sc.nextLine());
			bookNum[i] = new Book(name, ISBN); // creates a new object/instance of Book
			books.insertStart(bookNum[i]); // add new object/instance to Books array
		}
		
		print("\nDouble Linked List: ");
		books.print();
		print("\nEmpty? - " + books.isEmpty());
		print("Size? - " + books.size());
		print("");
		//
		
		System.out.print("Enter number of books to insert: " );
		String numberOfBooksFrontSTR = sc.nextLine();
		int numberOfBooksFront = Integer.parseInt(numberOfBooksFrontSTR);

		Book[] frontBook = new Book[numberOfBooksFront];
		for(int i = 0; i < numberOfBooksFront; i++){
			System.out.print("\nEnter name of book: ");
			String name = sc.nextLine();
			System.out.print("Enter ISBN of books: ");
			int ISBN = Integer.parseInt(sc.nextLine());
			frontBook[i] = new Book(name, ISBN); 
			System.out.print("Enter the position to insert the book: ");
			int pos = Integer.parseInt(sc.nextLine());
			books.insertAtPos(frontBook[i], pos);
			print("\nDouble Linked List: ");
			books.print();
		}

		System.out.print("Enter number of books to put at the end: " );
		String numberOfBooksEndSTR = sc.nextLine();
		int numberOfBooksEnd = Integer.parseInt(numberOfBooksEndSTR);
		Book[] endBook = new Book[numberOfBooksEnd];
		for(int i = 0; i < numberOfBooksEnd; i++){
			System.out.print("\nEnter name of book: ");
			String name = sc.nextLine();
			System.out.print("Enter ISBN of book: ");
			int ISBN = Integer.parseInt(sc.nextLine());
			endBook[i] = new Book(name, ISBN); 
			books.insertAtEnd(endBook[i]);
			print("\nDouble Linked List: ");
			books.print();
		}
		//
		print("\nSize? - " + books.size());
		print("");

		//work
		/*print("deleting first book");
		books.removeAtPos(bookNum[0]);
		*/
		System.out.print("Enter number of books to delete: ");
		String numberOfBooksDeleteSTR = sc.nextLine();
		int numberOfBooksDelete = Integer.parseInt(numberOfBooksDeleteSTR);

		for (int i = 0; i < numberOfBooksDelete; i++) {
    		System.out.print("Enter the position to delete book: ");
    		int pos = Integer.parseInt(sc.nextLine());
    		books.removeAtPos(pos);
    		books.print();
		}
		
		print("New linked list:");
		books.print();		
			
		print("");
		print("/nsize - " + books.size());
		print("Empty? - " + books.isEmpty());

		print("");
		print("New Linked List");
		books.print();
	}
	public static void print(String s){
		System.out.println(s);
	}
}