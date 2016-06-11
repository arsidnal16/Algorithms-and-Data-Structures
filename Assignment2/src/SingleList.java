

public class SingleList {
	
	private static Node head, current;
	private int listSize ;
	
	
	
	public SingleList(int length){
		
	head = null;
	listSize = 0;
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	
	public int size(){
		return listSize;
	}
	
	public void insert(int element){
		
	if (head == null){
		Node newNode = new Node(element);
		newNode.next = head;
		head = newNode;
		listSize++;
	}
	else{
			current = head;
			while(current.getNext() != null){
				current = current.next;
			}
			Node newNode = new Node(element);
			current.setNext(newNode);
			listSize++;
		
		
	}
	}

	public static boolean contains(int num) {
		Node node;
		node = head;
		boolean found = false;
		
		while(node != null && !found){
			if(num == node.getElement()){
				found = true;
			}
			else {
				node = node.getNext();
			}
		}
		
		
		return found;
	}
	
	public String toString(){
		String s = " "+ "\n";
		Node node;
		node = head;
		int count = 0 ;
		
		while(node != null){
			
			count ++;
			s = s+ " "+ count +". "+ node.getElement();
			node = node.getNext();
		}
		return s;
	}
	
	static void bubbleSort() {
		if(head == null){
			System.out.println("An empty linked list is already sorted");
		}
		else if (head.getNext() == null){
			System.out.println("A single element linked list is already sorted");
		}
		else{
			int numExchanges = 0;
			int numComparisons = 0;
			int numTraversals = 0;
			current = head;
			boolean swapped = true;
			while(swapped){
				swapped = false;
				while(current != null){
					if(current.getNext() != null && current.getElement() > current.getNext().getElement()){
						swap(current.getElement(), current.getNext().getElement());
						numExchanges++; // Incrementing exchanges if element is bigger
						swapped = true;
					}
					current = current.getNext();
					numComparisons++; // Incrementing the comparisons whether element is greater or next.
				}
				current = head;
				numTraversals++;   // Incrementing traversals here.
			}
			System.out.println("Number of exchanges made are "+ numExchanges);
			System.out.println("Number of node comparisons made are "+ numComparisons);
			System.out.println("Number of traversals made are "+ numTraversals);
		}
		
		
		
	}

	private static void swap(int element, int element2) {
		int temp = current.getElement();
		current.setelement(current.getNext().getElement());
		current.getNext().setelement(temp);
		
	}
	
	
	
	

}
