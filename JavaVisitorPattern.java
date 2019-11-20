/*
Sample Input

Step 1 Read array size and elements
5
4 7 2 5 12

Step 2 Read Color of elements red(0) ,Green(1)
0 1 0 0 1

Step 3 Read Node index that connected to other node(Specify the edge between two nodes)
1 2
1 3
3 4
3 5

Sample Output
24 Sum of Leaf nodes
40 Multiplication of red nodes
15 |(rootnode)-(sum of green nodes)|
*/
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
public class JavaVisitorPattern {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		try{
	
			// Step one read data
			System.out.println("Sample Input");
			int len = sc.nextInt();
			int arr[] = new int[len];			
			System.out.println("Enter node values");
			for(int i=0;i<len;i++) {
				arr[i]=sc.nextInt();
			}
			// End of step one
			
			// Step 2
			System.out.println("Enter node color 0 for red, 1 for green");	
			int color[] = new int[len];
			int red_size=0;
			int green_size=0;
			
			for(int i=0;i<len;i++) {
				int temp = sc.nextInt();
				if(temp==0) {
					color[i]=temp;
					red_size++;
				}				
				else if(temp==1) {
					color[i]=temp;
					green_size++;
				}
				else {
					i--;
					System.out.println("Wrong input");
				}				 			
			}
			
			int red[] = new int[red_size];
			int green[] = new int[green_size];			
			
			for(int i=0;i<len;i++) {
				if(color[i]==0) {
					red[red_size-1]=arr[i];
					red_size--;
				}
				if(color[i]==1) {
					green[green_size-1]=arr[i];
					green_size--;
				}
			}
			//End of Step 2
			
			//Step 3	
			System.out.println("Enter a node index that node connected to other : ");
			
			HashSet<Integer> non_leaf = new HashSet<Integer>(); 
			for(int i=0;i<len-1;i++) {	
				int connected = sc.nextInt();
				non_leaf.add(connected);
			}			
			Iterator<Integer> non_leaf_iter = non_leaf.iterator(); 
			
			HashSet<Integer> leaf = new HashSet<Integer>();
			Iterator<Integer> leaf_iter = leaf.iterator();
			
		/*	for(int i=0;i<len;i++) {
				while(non_leaf_iter.hasNext()) {
					if(i != non_leaf_iter.next()) {
						leaf.add(i);	
					}
				} 
			}
		*/	
		    //End of step 3
			
			System.out.println("Red nodes");
	    	for(int i=0;i<red.length;i++) {
				System.out.println(" "+red[i]);
			}

	    	
	    	System.out.println("Green nodes");
	    	for(int i=0;i<green.length;i++) {
				System.out.println(" "+green[i]);
			}

	    	
	    	
	    	System.out.println("non leaf node : "); 	        
	    	while (non_leaf_iter.hasNext()) {
	        	System.out.println(" "+arr[non_leaf_iter.next()]); 
	    	}

	    	
	    	
	    	System.out.println("leaf node : "); 	        
	    	while (leaf_iter.hasNext()) {
	        	System.out.println(" "+arr[leaf_iter.next()]); 
	    	}

	   	
	        System.out.println("Root node : "+arr[0]);
	        
	        //Second output
	        int multi_red = 1;
	        for(int i=0;i<red.length;i++) {
	        	multi_red = multi_red * red[i]; 
	        }
	        
	        System.out.println("Multiply of red node is : "+multi_red);
	        
	        
	        
	        
	        
		}catch(NumberFormatException e) {
			System.out.println("Invalid Number");
		}finally {
			sc.close();
		}
	}
}
