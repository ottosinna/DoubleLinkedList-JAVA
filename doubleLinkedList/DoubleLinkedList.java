class DoubleLinkedList<T> implements DoubleLinkedListInterface<T> {

	// member/instance vars
	private Node<T> start;
	private Node<T> end;
	private int size;

	// O(1)
	public void insertStart(T item) {
	
		// create a new Node with item
		Node<T> newNode = new Node<T>(item);
		
		// if list is empty (brand new double linked list)
		if(start == null) {
			start = newNode;
			end =  start;
		}
		// else list already contains nodes
		else {
			// 3 steps:
			start.setPrev(newNode); // step 1
			newNode.setNext(start); // step 2
			start = newNode; // step 3
		}
		
		size++;
	
	}
	
	// O(n)
	public void insertAtPos(T item, int pos) {
		Node<T> tmp = new Node<T>(item);
		Node<T> next = start;
		if(pos < 0 || pos > size){
			throw new IllegalArgumentException("Illigal position, pos at " + pos + "  fix it.");
		}
		
		if(pos == 1){
			tmp.setNext(start); 
			start = tmp;
		} 
		else if(pos == size){
			end.setNext(tmp);
			tmp.setPrev(end); //?
			end = tmp;
		}
		else{
			for(int i = 2; i < pos; i++){
				next = next.getNext();
			} 
			tmp.setNext(next.getNext()); //set -> next
			tmp.setPrev(next);  
			next.setNext(tmp);
			next.getNext().setPrev(tmp); //xzmc
		}
			size++;
	}
	
	// O(1)
	public void insertAtEnd(T item) {
		Node<T> endNode = new Node<T>(item);
		if(start == null){
			start = endNode;
			end = start;
		} 
		/* 
		start.setPrev(newNode); // step 1
		newNode.setNext(start); // step 2
		start = newNode; // step 3
		 */
		else{		
			endNode.setPrev(end); 
			end.setNext(endNode); 
			end = endNode;
		}
		size++;
	}
	
	// O(n)
	public void removeAtPos(int pos) {
	
		// 0. If list is empty!
		if(start == null) {
			// option 1
			// throw new ...
			// option 2
			System.out.println("THERE IS NOTHING IN THE LIST");			
		}
		// 1. Removing first item (i.e. pos == 1)
		else if(pos == 1) {
			// 1.a if there is ONLY one item in the list
			if(size == 1) {
				start = null;
				end = null;
				size = 0;				
			}
			// 1.b there are more than 1 item in the list
			else {
				start = start.getNext();
				start.setPrev(null);
				size--;			
			}
		}		
		// 2. Removing last item (i.e. pos == size)
		else if(pos == size) {
			end = end.getPrev();
			end.setNext(null);
			size--;
		}		
		// 3. Removing Nth item
		else {
			Node<T> tmp = start.getNext();
			for(int i = 2; i < size; i++) {
				if(pos == i) {
					Node<T> p = tmp.getPrev();
					Node<T> n = tmp.getNext();
					p.setNext(n);
					n.setPrev(p);
					size--;
				}
				tmp = tmp.getNext();
			}		
		}	
	}
	
	// O(1)
	public int size() {
		return size;
	}
	
	// O(1)
    public boolean isEmpty() {
		if(start == null || end == null) {
			return true;
		} else{
			return false;
		} 
	}
	
	// O(n)
	public void print() {
	
		int i = 0;
		if(size == 0) {
			System.out.println("List is empty.");
		}
		else if(size == 1) {
			System.out.println("null <- " + start.getItem() + " -> null");
		}
		else {
			System.out.print("null <- ");
			Node<T> tmp = start;
			while(tmp != null) {
				if(i == 0) {					
					i++;
				}
				else {
					System.out.print("> ");
				}
				System.out.print(tmp.getItem());
				tmp = tmp.getNext();
				if(tmp == null) {
					System.out.print(" ->");
				}
				else {
					System.out.print(" <-");
				}
			}			
			System.out.print(" null");
			System.out.println("\n=======================================================");
		}	
	}
}