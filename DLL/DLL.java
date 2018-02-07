package data.structures;

// Doubly Linked List (DLL)
public class DLL {
	
	private DLN Head = null;
	
	private DLN Tail = null;
	
	public void Print()
	{
		DLN scroll = Head;
		while(scroll != null)
		{
			System.out.println(scroll.GetValue());
			scroll = scroll.GetNext();
		}
	}
	
	public void AddSorted(int number)
	{
		DLN node = new DLN();
		node.SetValue(number);
		
		// If the list is empty.
		// Adds first element.
		if(Head == null)
		{
			node.SetNext(null);
			node.SetPrevious(null);
			Head = node;
			Tail = node;
			return;
		}
		
		// If value is smaller than list's head.
		// Adds first.
		if( node.GetValue() < Head.GetValue() )
		{
			node.SetNext(Head);
			node.SetPrevious(null);
			Head.SetPrevious(node);
			Head = node;
			return;
		}
		
		// If value is greater than list's tail.
		// Adds last.
		if( node.GetValue() > Tail.GetValue() )
		{
			node.SetNext(null);
			node.SetPrevious(Tail);
			Tail.SetNext(node);
			Tail = node;
			return;
		}
		
		// If value is greater than list's head.
		// Adds in between
		DLN scroll = Head;
		while(scroll != null)
		{
			if(node.GetValue() > scroll.GetValue() && node.GetValue() < scroll.GetNext().GetValue() )
			{
				node.SetNext(scroll.GetNext());
				node.SetPrevious(scroll);
				scroll.GetNext().SetPrevious(node);
				scroll.SetNext(node);
				return;
			}
			scroll = scroll.GetNext();
		}
		
	}

}
