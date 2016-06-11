
public class DoublyList {
	
	
	private static Node start,current, end;
	private static int listSize ;
	
	
	
	public DoublyList(int length){
		
	start = null;
	end = null;
	listSize = 0;
	
	}
	
	public static boolean isEmpty(){
		return listSize == 0;
	}
	
	
	public int size(){
		return listSize;
	}
	
	public void insert(int element){
		Node newNode = new Node(element);
		if(isEmpty()){
		newNode.next = end;
		newNode.previous = start;
		start = newNode;
		end=newNode;
		listSize++;
		}
		else{
			start.previous = newNode;
			newNode.next = start;
			newNode.previous = null;
			start = newNode;
			listSize++;
			
		}
	
	}
	public String toString(){
		String s = " "+ "\n";
		Node node;
		node = start;
		int count = 0 ;
		
		while(node != null){
			
			count ++;
			s = s+ " "+ count +". "+ node.getElement();
			node = node.getNext();
		}
		return s;
	}
	
	static void bubbleSort() {
		if(isEmpty()){
			System.out.println("An empty linked list is already sorted");
		}
		else if (start.getNext() == null){
			System.out.println("A single element linked list is already sorted");
		}
		else{
			int numExchanges = 0;
			int numComparisons = 0;
			int numTraversals = 0;
			current = start;
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
				current = start;
				numTraversals++;  // Incrementing traversals here.
			}
			System.out.println("Number of exchanges made are "+ numExchanges);
			System.out.println("Number of node comparisons made are "+ numComparisons);
			System.out.println("Number of traversals made are "+ numTraversals);
		}
		
		
		
	}

	private static void swap(int element, int element2) {
		int temp = current.getElement(); // storing element in temp
		current.setelement(current.getNext().getElement());
		current.getNext().setelement(temp);
		
	}
	
	
	
	
	

}
