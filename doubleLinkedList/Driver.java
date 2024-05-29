class Driver {

	public static void main(String[] args) {
	
		// TODO: Use Scanner for ALL inputs (when creating new objects of Book)
	
		DoubleLinkedList<Book> bookList = new DoubleLinkedList<Book>(); // Complete ALL unimplemented Methods
		
		Book b1 = new Book("A", 1);
		Book b2 = new Book("B", 2);
		Book b3 = new Book("C", 3);
		Book b4 = new Book("D", 4);
		
		bookList.insertStart(b4);
		bookList.insertStart(b3);
		bookList.insertStart(b2);
		bookList.insertStart(b1);
		
		bookList.print();
	
		// Complete Driver by implementing the steps defined in Lecture 08 - Slide 36
		// User Defined type = Book
	}

}