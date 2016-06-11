
public class Node
	{
		
		Node next, previous;
		int element;
		

		
		public Node(int element)
		{
			this.element = element;
		}
		public int getElement()
		{
			return element;
		}
		
		public void setelement(int element)
		{
			this.element = element;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node next)
		{
			this.next = next;
		}
		

		
		
	}

