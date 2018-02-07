package data.structures;
import java.util.List;
import java.util.*;

// Tree
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
	
	public void TraverseTreeLeftNodeRight( TreeNode root, List<Integer> storage )
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
