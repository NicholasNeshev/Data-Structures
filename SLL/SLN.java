package data.structures;

// Singly Linked Node (SLN)
public class SLN 
{
	private int Value;
	private SLN Next;
	
	public void SetValue(int value)
	{
		this.Value = value;
	}
	
	public int GetValue()
	{
		return this.Value;
	}
	
	public void SetNext(SLN nextNode)
	{
		this.Next = nextNode;
	}
	
	public SLN GetNext()
	{
		return this.Next;
	}
}
