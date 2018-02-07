package data.structures;

public class TreeNode {
	
	private int Value;
	private TreeNode Left;
	private TreeNode Right;
	
	public TreeNode()
	{
		this.Value = 0;
		this.Left = null;
		this.Right = null;
	}
	
	public TreeNode( int val, TreeNode left, TreeNode right)
	{
		this.Value = val;
		this.Left = left;
		this.Right = right;
	}
	
	public void SetValue(int value)
	{
		this.Value = value;
	}
	
	public int GetValue()
	{
		return this.Value;
	}
	
	public void SetRight(TreeNode rightNode)
	{
		this.Right = rightNode;
	}
	
	public TreeNode GetRight()
	{
		return this.Right;
	}
	
	public void SetLeft(TreeNode leftNode)
	{
		this.Left = leftNode;
	}
	
	public TreeNode GetLeft()
	{
		return this.Left;
	}
	
}
