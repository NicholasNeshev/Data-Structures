package data.structures;

// Doubly Linked Node
public class DLN {

	private int Value;
	private DLN Next;
	private DLN Previous;
	
	public void SetValue(int value)
	{
		this.Value = value;
	}
	
	public int GetValue()
	{
		return this.Value;
	}
	
	public void SetNext(DLN nextNode)
	{
		this.Next = nextNode;
	}
	
	public DLN GetNext()
	{
		return this.Next;
	}
	
	public void SetPrevious(DLN prevNode)
	{
		this.Previous = prevNode;
	}
	
	public DLN GetPrevious()
	{
		return this.Previous;
	}
	
}
