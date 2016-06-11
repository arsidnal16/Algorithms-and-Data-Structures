
import java.util.Arrays;
import java.util.Random;

import org.w3c.dom.Node; 



public class BubbleSort{ 
	
	
	
	
	public static void main(String args[]) { 
		
	 
		
		SingleList items=new SingleList(0);
		DoublyList doubleItems = new DoublyList(0);
		Random gen = new Random();
		int num, dnum;
		
		int n = gen.nextInt(100);
		int dn = gen.nextInt(100);
		System.out.println("Size of the Single list is "+ n);
		
		
		
		for(int i=0;i<n; i++){
			num = gen.nextInt(50000);
			//System.out.println(num);
			if (!SingleList.contains(num)){
				items.insert(num);
			}
			
		}
		for(int i=0;i<dn; i++){
			dnum = gen.nextInt(50000);
			//System.out.println(dnum);
			if (!SingleList.contains(dnum) ){
				doubleItems.insert(dnum);
			}
			
		}
		System.out.println("The singly linked list is " +items.toString() );
		
		items.bubbleSort();
		System.out.println("The sorted singly linked list is " +items.toString());
		
		System.out.println("----------------------------------------------------------");
		
		System.out.println("Size of the doubly linked list is "+ dn);
		System.out.println("The doubly linked list is " +doubleItems.toString() );
		
		doubleItems.bubbleSort();
		System.out.println("The sorted doubly linked list is " +doubleItems.toString());
		
		} 
} 

