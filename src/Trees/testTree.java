package Trees;

class Node{
	
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	int getData()
	{
		return this.data;
	}
	
	Node getLeft()
	{
		return this.left;
	}
	
	Node getRight()
	{
		return this.right;
	}
	public void setData(int data)
	{
		this.data = data;
	}
	
	void setLeft(Node m)
	{
		
		this.left = m;	
	}
	
	void setRight(Node m)
	{
		
		this.right = m;	
	}
	
	
}


public class testTree {
	
	public Node insertIntoBST(Node root,int data)
	{
		if(root == null)
		{
			return new Node(data);
		}
		else if(data <= root.data)
		{
			root.setLeft(insertIntoBST(root.left,data));
		}
		else
		{
			root.setRight(insertIntoBST(root.right,data));
		}
		return root;
	}
	
	
	
	 /* Traversing the tree common for both BST and binary tree*/
	
	
	 /* Inorder traversal*/
	public void inOrder(Node root)
	{
		if(root == null)
			return;
		else{
			inOrder(root.left);
			System.out.print(root.getData()+" ");
			inOrder(root.right);
			
		}
		
	}
	
	/*PreOrder traversal*/

		public void preOrder(Node root)
		{
			if(root == null)
				return;
			else{
				System.out.print(root.getData()+" ");
				preOrder(root.getLeft());
				preOrder(root.getRight());
				
			}
			
		}
	
		/*PostOrder traversal*/

		public void postOrder(Node root)
		{
			if(root == null)
				return;
			else{
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.getData()+" ");
				
			}
			
		}
		
	/*Getting height of the tree assumming the root is at 0th level
	 * Same for BST and Binary*/
	public int getHeight(Node root)
	{
		if(root == null)
			return -1;
		else
			return Math.max(getHeight(root.getLeft()),getHeight(root.getRight()))+1;
	}
		
	/**/
	
	
	public Node Delete(Node root, int data)
	{
		if (root == null)
		{
			return root;
		}
		
		if(data < root.data)
		{
			root.setLeft(Delete(root.getLeft(), data));
		}
		else if(data > root.data)
		{
			root.setRight(Delete(root.getRight(),data));
		}
		else
		{
			if(root.getLeft() == null && root.getRight() == null)
			{
				return root.getLeft();
			}
			else if(root.getLeft() == null)
			{
				return root.getRight();
			}
			else if(root.getRight() == null)
			{
				return root.getLeft();
			}
			
			
			/*Find the inOrder successor of the right subtree, ie. minimum value of the right subtree*/
			root.setData(findMin(root));
			root.setRight(Delete(root.getRight(),root.getData()));
			
		}
		return root;
	}
	
	public int findMin(Node root)
	{
		int min = root.getData();
		
		root = root.getRight();
		while(root.getLeft() != null)
		{
			min = root.getLeft().getData();
			root = root.getLeft();
		}
		return min;
	}
	
	/*Driver code*/	
	public static void main(String[] args)
	{
		
		testTree tt = new testTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
		
	   int [] arr = {50,30,20,40,70,60,80};
	   
	   Node root = new Node(arr[0]);
	   
	   for(int i=1;i<arr.length;i++)
	   {
		   tt.insertIntoBST(root,arr[i]);
	   }
	   
	  
	   /*Node current = root;
	   while(current != null)
	   {
		   System.out.println(current.getData());
		   current = current.getLeft();
		   
	   }
	   System.out.println(root.getLeft().getData());*/
	   
	   /* Traversing the tree common for both BST and binary tree*/
	   /*PreOrder, Post and Inorder traversals in recursive approach*/
	   
	   //tt.preOrder(root);
	   System.out.println();
	   //tt.postOrder(root);
	   System.out.println();
	   tt.inOrder(root);
	   System.out.println();
	   
	   /*Deleting the node in BST*/
	   //tt.Delete(root, 30);
	   //tt.inOrder(root);

       System.out.println("\nDelete 20");
       tt.Delete(root,20);
       System.out.println("Inorder traversal of the modified tree");
       tt.inOrder(root);

       System.out.println("\nDelete 30");
       tt.Delete(root,30);
       System.out.println("Inorder traversal of the modified tree");
       tt.inOrder(root);

       System.out.println("\nDelete 50");
       tt.Delete(root,50);
       System.out.println("Inorder traversal of the modified tree");
       tt.inOrder(root);
	   
	   
	   /*Calculating the height of the tree recursive*/
	   
	  System.out.println("Height of the tree:"+tt.getHeight(root));
	   
	  
	   
	   
	}
}
