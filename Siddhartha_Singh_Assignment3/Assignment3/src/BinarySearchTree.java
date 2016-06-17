import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class BinarySearchTree {
	
	
	Node root, current;
	
	public BinarySearchTree(){
		root = null;
	}
	
public static void main(String args[]){

		int num;
		int avgHeight100= 0;
		int avgHeight500 = 0;
		int avgHeight1000 = 0;
		Random gen = new Random();
		int n = gen.nextInt((100) + 1) + 0;
		int arr[] = new int[n];
		int arrbig[] = new int[1000];
		int avg[] = new int[1000];
		boolean flag = true;
		boolean flag500 = true;
		boolean flag1000 = true;
		
 
	for(int i=0;i<n; i++){
			num = gen.nextInt();
			if(!Arrays.asList(arr).contains(num)){ // No duplicate elements in the array
					arr[i] = num;
			}
		}
	for(int k =0;k<100;k++){   // Running this 100 times
		
			knuthShuffle(arr);  //Shuffling the array with knuth algorithm
		
			BinarySearchTree tree = new BinarySearchTree();  
			for(int i=0;i< arr.length;i++){
				tree.insert(arr[i]);     // Inserting the elements in the BST 
			}
			
		if(flag == true){	
			System.out.println("The inorder traversal is ");
			tree.inOrder();
			System.out.println("");
			System.out.println("The preorder traversal is ");
			tree.preorder();
			System.out.println("");
			System.out.println("The postorder traversal is ");
			tree.postorder();
			System.out.println("");
			flag =false;
		}
			int height = maxHeight(tree.root);   // Calculating height
			avg[k]= height;
		}
 
	for(int i = 0;i<100;i++){
		avgHeight100 = avgHeight100 + avg[i];
		}
	double avgH100 = avgHeight100/100;  // Average height for 100 runs
	System.out.println("The average height in 100 runs is "+avgH100);
 

		
// For 500 times and inserting in the 1000 items array
		
			for(int i=0;i<arrbig.length; i++){
			num = gen.nextInt();
			if(!Arrays.asList(arrbig).contains(num)){  // So that an element is only inserted once
				arrbig[i] = num;
				}
		}
	for(int k =0;k<500;k++){
		
			knuthShuffle(arr);  //Shuffling the array with knuth algorithm
	
		BinarySearchTree tree500 = new BinarySearchTree();
			for(int i=0;i< arrbig.length;i++){
				tree500.insert(arrbig[i]);   // Inserting the elements in the BST
			}
			if(flag500 == true){
				System.out.println("The inorder traversal is ");
				tree500.inOrder();
				System.out.println("");
				System.out.println("The preorder traversal is ");
				tree500.preorder();
				System.out.println("");
				System.out.println("The postorder traversal is ");
				tree500.postorder();
				System.out.println("");
				flag500 =false;
			}
			
			int height = maxHeight(tree500.root);  // Calculating height
			avg[k]= height;
		}
		
	for(int i = 0;i<500;i++){
		avgHeight500 = avgHeight500 + avg[i];
	}
	double avgH500 = avgHeight500/500;
	System.out.println("The average height in 500 runs is "+avgH500);
		
		
	// For 1000 times and an array of size 1000	
		
	for(int i=0;i<arrbig.length; i++){
					num = gen.nextInt();
					if(!Arrays.asList(arrbig).contains(num)){
					arrbig[i] = num;
					}
				
				}
	for(int k =0;k<1000;k++){
				
					knuthShuffle(arr);  //Shuffling the array with knuth algorithm
				
					BinarySearchTree tree1000 = new BinarySearchTree();
					for(int i=0;i< arrbig.length;i++){
						tree1000.insert(arrbig[i]);   // Inserting the elements in the BST
					}
					
					if(flag1000 == true){
						//System.out.println(Arrays.toString(arr));	
						System.out.println("The inorder traversal is ");
						tree1000.inOrder();
						System.out.println("");
						System.out.println("The preorder traversal is ");
						tree1000.preorder();
						System.out.println("");
						System.out.println("The postorder traversal is ");
						tree1000.postorder();
						System.out.println("");
						flag1000 =false;
					}
					int height = maxHeight(tree1000.root);   // Calculating height
					avg[k]= height;
			}
				
		for(int i = 0;i<1000;i++){
			avgHeight1000 = avgHeight1000 + avg[i];
			}
		double avgH1000 = avgHeight1000/1000;
		System.out.println("The average height in 1000 runs is "+avgH1000);
		
	}

	public static void knuthShuffle(int[] arr) {
		int len = arr.length;
		for(int i=0; i<len; i++){
			int rand = i +(int) (Math.random() * (len-i));
			int temp = arr[rand];
			arr[rand]= arr[i];
			arr[i] = temp;
		}
		
	}
	
	
	public void insert(int element){
		root = insert(root, element);
		}
	
	public Node insert(Node root, int element){ // A function to insert a new key in Binary search tree(BST)
		
		if(root == null ){
			root = new Node(element); // If the tree is empty return a new node
			//System.out.println("The root inserted is " + root.data );
			return root;
			
		}
		else{
			if (element < root.data){  
				root.left = insert(root.left, element); //recurse the left subtree
			}
			else{
				root.right =insert(root.right, element); // recurse the right subrtree
			}
		}
		return root;
		
	}
	
	public static int maxHeight(Node node){
		if(node == null){
			return 0;
		}
		else{
			int ldepth = maxHeight(node.left);
			int rdepth = maxHeight(node.right);
			
			if(ldepth > rdepth){
				return ldepth + 1;
			}
			else{
				return rdepth + 1;
			}
		}
		
	}
	
	
public void inOrder(){
		
		if(root == null){
			return;
		}
		Stack<Node> s = new Stack<Node>();
		current = root;
		
		while(current!=null){
			s.push(current);
			current = current.left;
		}
		while(s.size() > 0){
			current = s.pop(); 
			System.out.print(current.data+ " ");
			if(current.right != null){
				current = current.right;
				while(current != null){
					s.push(current);
					current = current.left;
				}
			}
		}
		
		
	}

public void preorder() {
    
    
    if (root == null) {
        return;
    }
    
    Stack<Node> s = new Stack<Node>();
    s.push(root);
    
    while (s.empty() == false) {
       
        Node node = s.peek();
        System.out.print(node.data + " ");
        s.pop();

        if (node.right != null) {
            s.push(node.right);
        }
        if (node.left != null) {
            s.push(node.left);
        }
    }
}
	
public void postorder() {
	
	
    if(root==null) {
        return;
    }
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
 
    while(!stack.isEmpty()) {
        Node temp = stack.peek();
        if(temp.left==null && temp.right==null) {
        	System.out.print(temp.data + " ");
        	stack.pop();
        }
        else {
            if(temp.right!=null) {
                stack.push(temp.right);
                temp.right = null;
            }
 
            if(temp.left!=null) {
                stack.push(temp.left);
                temp.left = null;
            }
        }
    }
}

	
}