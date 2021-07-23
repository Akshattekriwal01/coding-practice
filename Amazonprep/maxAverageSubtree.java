import java.util.*;
// Represents a node of an n-ary tree
 class Node
{
    int key;
    List<Node >child = new ArrayList<>();
    public Node(int key) {
    	this.key = key ;
    }
};
// LEETCODE LINK https://leetcode.com/problems/maximum-average-subtree/
class Pair1{
	Node highestManager ;
	double maxAverage ;
	int sizeOfSubtree ;
	double average;
	
	public Pair1(Node root , double a , int b, double c ) {
		this.highestManager  = root;
		maxAverage  = a ;
		sizeOfSubtree = b ;
		average = c ;
		
	}
}
public class maxAverageSubtree {
	 
	  public static Pair1 average(Node root) {
		  
		  if(root.child.size() == 0 ) {
			  return new Pair1(root,root.key,1,root.key);
		  }else {
			  double maxAverage = -100000 ;
			  int totalSize = 1 ;
			  double totalAverage = 0 ;
			  Node highestManager = null ;
			  for(Node child : root.child) {
				  Pair1 p = average(child);
				  if(maxAverage < p.maxAverage ) {
					  maxAverage = p.maxAverage  ;
					  highestManager = child;
				  }
				  totalSize += p.sizeOfSubtree ;
				  totalAverage += (p.sizeOfSubtree * p.average);
			  }
			  totalAverage = totalAverage/totalSize ;
			  if(maxAverage > maxAverage) {
				  maxAverage = totalAverage;
				  highestManager = root;
			  }
			  return new Pair1(highestManager, maxAverage, totalSize, totalAverage);
		  }
	  }
	  
	
	  
	   

	   
	  // Utility function to create a new tree node
	   
	  // Prints the n-ary tree level wise
	  static void LevelOrderTraversal(Node root)
	  {
	      if (root == null)
	          return;
	   
	      // Standard level order traversal code
	      // using queue
	      Queue<Node > q = new LinkedList<>(); // Create a queue
	      q.add(root); // Enqueue root
	      while (!q.isEmpty())
	      {
	          int n = q.size();
	   
	          // If this node has children
	          while (n > 0)
	          {
	              // Dequeue an item from queue
	              // and print it
	              Node p = q.peek();
	              q.remove();
	              System.out.print(p.key + " ");
	   
	              // Enqueue all children of
	              // the dequeued item
	              for (int i = 0; i < p.child.size(); i++)
	                  q.add(p.child.get(i));
	              n--;
	          }
	           
	          // Print new line between two levels
	          System.out.println();
	      }
	  }
	   public static void display(Node root) {
		   Queue<Node> q = new LinkedList<>();
		   q.add(root);
		   
		   while(!q.isEmpty()) {
			   int size = q.size();
			   System.out.println();
			   for(int i = 0 ; i < size ; i++) {
				   Node n = q.poll();
				   System.out.print(n.key+",");
				   for(int j = 0 ; j < n.child.size(); j++) {
					   q.add(n.child.get(j));
				   }
			   }
			  
		   }
	   }
	  // Driver Code
	  public static void main(String[] args)
	  {
	       
	      /* Let us create below tree
	      *             10
	      *     / / \ \
	      *     2 34 56 100
	      *     / \         | / | \
	      *     77 88     1 7 8 9
	      */
	      Node root = new Node(10);
	      (root.child).add(new Node(2));
	      (root.child).add(new Node(34));
	      (root.child).add(new Node(56));
	      (root.child).add(new Node(100));
	      (root.child.get(0).child).add(new Node(77));
	      (root.child.get(0).child).add(new Node(88));
	      (root.child.get(2).child).add(new Node(1));
	      (root.child.get(3).child).add(new Node(7));
	      (root.child.get(3).child).add(new Node(8));
	      (root.child.get(3).child).add(new Node(9));
	   
	      Pair1 p = average(root);
	      display(root);
	      System.out.println(p.highestManager.key);
	  }
	  
}



   


