package data.structures;

import java.util.Stack;

public class SLL
{
	private SLN Head = null;
	
	public SLN GetHead()
	{
		return Head;
	}
	
	public void AddFirst(int number)
	{
		SLN node = new SLN();
		node.SetValue(number);
		
		if(Head == null)
		{
			node.SetNext(null);
		}
		else
		{
			node.SetNext(Head);
		}
		Head = node;
	}
	
	public void AddLast(int number)
	{
		 SLN node = new SLN();
		 node.SetValue(number);
		 node.SetNext(null);
		 
		 if(Head == null)
		 {
			 Head = node;
		 }
		 else
		 { 
			 SLN scroll = Head;
			 while(scroll.GetNext() != null)
			 {
				 scroll = scroll.GetNext();
			 }
			 scroll.SetNext(node);
		 }
	}
	
	public void AddLastLoop(int number)
	{
		 SLN node = new SLN();
		 node.SetValue(number);
		 node.SetNext(Head);
		 
		 if(Head == null)
		 {
			 Head = node;
		 }
		 else
		 { 
			 SLN scroll = Head;
			 while(scroll.GetNext() != null)
			 {
				 scroll = scroll.GetNext();
			 }
			 scroll.SetNext(node);
		 }
	}
	
	public void AddSorted(int number)
	{
		SLN node = new SLN();
		node.SetValue(number);
		
		// If the list is empty.
		// Adds first element.
		if(Head == null)
		{
			node.SetNext(null);
			Head = node;
			return;
		}
		
		// If value is smaller than list's head.
		// Adds first.
		if( node.GetValue() < Head.GetValue() )
		{
			node.SetNext(Head);
			Head = node;
			return;
		}
		
		// If value is greater than list's head.
		// Adds inbetween or last.
		SLN scroll = Head;
		while(scroll != null)
		{
			if(node.GetValue() > scroll.GetValue() && ( scroll.GetNext() == null || node.GetValue() < scroll.GetNext().GetValue() ))
			{
				node.SetNext(scroll.GetNext());
				scroll.SetNext(node);
				return;
			}
			scroll = scroll.GetNext();
		}
		
	}
	
	public void Print()
	{
		SLN scroll = Head;
		while(scroll != null)
		{
			System.out.println(scroll.GetValue());
			scroll = scroll.GetNext();
		}
	}
	
	public void PrintLoop( int cycles )
	{
		SLN scroll = Head;
		for( int i = 0; i < cycles; i++)
		{
			System.out.println(scroll.GetValue());
			scroll = scroll.GetNext();
		}
	}
	
	public void InitializeListOne()
	{
		AddLast(3);
		AddLast(4);
		AddLast(8);
		//AddLast(1);
		//AddLast(6);
		//AddLast(2);
		//AddLast(5);
	}
	
	public void InitializeList(int[] arr)
	{
		for(int elem: arr)
		{
			AddLast(elem);
		}
	}
	
	public void InitializeListCircle()  
	{
		AddLast(1);
		AddLast(2);
		AddLast(3);
		AddLast(4);
		AddLast(5);
		AddLast(6);
		AddLastLoop(7);
	}
	public int FindNthElement(int n) throws Exception
	{
		if( Head == null || n < 1)
		{
			throw new Exception("Out of bounds");
		}
		
		SLN scroll = Head;
		int counter = 1;
				
		while( counter < n && scroll.GetNext() != null)
		{
			scroll = scroll.GetNext();
			counter++;
		}
		
		if( counter == n)
		{
			return scroll.GetValue();
		}
		
		throw new Exception("Out of bounds");
	}
	
	public void AddAfterNthElement(int number, int n) throws Exception
	{
		if( n < 0 || Head == null )
		{
			throw new Exception("List not ");
		}
		
		SLN node = new SLN();
		node.SetValue(number);
		
		if( n == 0 )
		{
			node.SetNext(Head);
			Head = node;
			return;
		}
		
		SLN scroll = Head;
		int counter = 1;
				
		while( counter < n && scroll.GetNext() != null)
		{
			scroll = scroll.GetNext();
			counter++;
		}
		
		if( counter == n )
		{
			node.SetNext(scroll.GetNext());
			scroll.SetNext(node);
		}
		else
		{
			throw new Exception("Out of bounds");
		}
		
	}
	
	public void DeleteNthElement( int n )
	{
		if( n <= 0 || Head == null )
		{
			System.out.println("error");
			return;
		}
		
		if( n == 1 )
		{
			Head = Head.GetNext();
			return;
		}
		
		SLN scroll = Head;
		int counter = 1;
				
		while( counter < n-1 && scroll.GetNext() != null)
		{
			scroll = scroll.GetNext();
			counter++;
		}
		
		if(counter == n-1 && scroll.GetNext() != null)
		{
			scroll.SetNext(scroll.GetNext().GetNext());
		}
		else
		{
			System.out.println("error");
		}
	}
	
	public int FindFromLastNthElement( int n) throws Exception
	{
		if( Head == null || n < 1)
		{
			throw new Exception("Out of bounds");
			
		}
		
		SLN scroll1 = Head;
		int counter1 = 1;
				
		while( counter1 < n && scroll1.GetNext() != null)
		{
			scroll1 = scroll1.GetNext();
			counter1++;
		}
		
		SLN scroll2 = Head;
				
		while( scroll1.GetNext() != null )
		{
			scroll1 = scroll1.GetNext();
			scroll2 = scroll2.GetNext();
		}

		if(counter1 == n)
		{
			return scroll2.GetValue();
		}
		
		throw new Exception("Out of bounds");
	}
	
	public void DeleteNthElementNoHead( SLN node )
	{		
		
		node.SetValue(node.GetNext().GetValue());
		node.SetNext(node.GetNext().GetNext());

	}
	
	public int FindMiddleElement() throws Exception
	{
		if( Head == null )
		{
			throw new Exception("Out of bounds");
		}
		
		if( Head.GetNext() == null)
		{
			return Head.GetValue();
		}
		
		SLN slow = Head;
		SLN fast = Head;
				
		while( fast.GetNext() != null && fast.GetNext().GetNext() != null)
		{
			slow = slow.GetNext();
			fast = fast.GetNext().GetNext();
		}
		
		return slow.GetValue();
	}
	
	public boolean IsLoop()
	{
		SLN slow = Head;
		SLN fast = Head;
				
		while( fast.GetNext() != null && fast.GetNext().GetNext() != null)
		{
			slow = slow.GetNext();
			fast = fast.GetNext().GetNext();
			
			if( slow.GetValue() == fast.GetValue())
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void ReverseList() throws Exception
	{
		if( Head == null || Head.GetNext() == null )
		{
			return;
		}
		
		Stack<Integer> myStack = new Stack<Integer>();
		
		SLN scroll = Head;
		
		while( scroll != null )
		{
			myStack.push(scroll.GetValue());
			scroll = scroll.GetNext();
		}
		
		SLL listR = new SLL();
		
		while( !myStack.empty() )
		{
			int number = myStack.pop();
			SLN node = new SLN();
			node.SetValue(number);
			node.SetNext(null);
			
			if( listR.Head == null)
			{
				listR.Head = node;
			}
			else
			{
				scroll.SetNext(node);
			}			

			scroll = node;
			
			throw new Exception("hi");
		}
		
		Head = listR.Head;
	}
	
}
