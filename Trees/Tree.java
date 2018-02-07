package data.structures;
import java.util.List;
import java.util.*;

public class Tree {
	
	private TreeNode Root = null;
	
	public TreeNode GetRoot()
	{
		return Root;
	}
	
	public void SetRoot (TreeNode treeNode)
	{
		this.Root = treeNode;
	}
	
	public void InitializeTree()
	{
		TreeNode TN1 = new TreeNode( 1, null, null);
		TreeNode TN4 = new TreeNode( 4, null, null);
		TreeNode TN3 = new TreeNode( 3, TN1, TN4);
		TreeNode TN7 = new TreeNode( 7, null, null);
		TreeNode TN5 = new TreeNode( 5, TN3, TN7);
		TreeNode TN15 = new TreeNode( 15, null, null);
		TreeNode TN10 = new TreeNode( 10, TN5, TN15);
		SetRoot(TN10);
	}
	
	public void TraverseTreeLNR( TreeNode root, List<Integer> storage )
	{
		
		if( root == null )
		{
			return;
		}
		
		TraverseTreeLNR( root.GetLeft(), storage );
		storage.add( root.GetValue() );
		TraverseTreeLNR( root.GetRight(), storage );
	}
	
	public void PrintLineByLine()
	{
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
		myQueue.add(Root);
		
		while( !myQueue.isEmpty() )
		{
			TreeNode currentNode = myQueue.remove();
			System.out.println(currentNode.GetValue());
			
			if(currentNode.GetLeft() != null)
			{
				myQueue.add(currentNode.GetLeft());
			}
			
			if(currentNode.GetRight() != null)
			{
				myQueue.add(currentNode.GetRight());
			}
		}
	}
	
	public boolean FindElement(int number, TreeNode root)
	{
		boolean find = false;
		if (root == null)
		{
			return false;
		}
		if( root.GetValue() == number)
		{
			return true;
		}
		
		if (number < root.GetValue())
		{
			find = FindElement(number, root.GetLeft());
		}
		if (number > root.GetValue())
		{
			find = FindElement(number, root.GetRight());
		}
		
		return find;
	}
	
	public TreeNode CreateBalancedTree(List<Integer> storage, int start, int end)
	{
		if (start > end)
		{
			return null;
		}
		
		TreeNode root = new TreeNode();
		int index = start + (end - start)/2;
		
		// set value to the element in storage that has the middle index
		root.SetValue(storage.get(index));
		root.SetLeft(CreateBalancedTree(storage, start, index - 1));
		root.SetRight(CreateBalancedTree(storage, index + 1, end));		
		
		return root;
	}
}
