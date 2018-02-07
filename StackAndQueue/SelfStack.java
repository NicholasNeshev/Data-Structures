package data.structures;

import java.util.LinkedList;
import java.util.Queue;

// Custom stack
public class SelfStack {
	
	private Queue<Integer> myQueue1 = new LinkedList<Integer>();
	private Queue<Integer> myQueue2 = new LinkedList<Integer>();
	
	public void push( int number )
	{
		while( !myQueue1.isEmpty() )
		{
			int numb = myQueue1.remove();
			myQueue2.add(numb);
		}
		
		myQueue1.add(number);
		
		while( !myQueue2.isEmpty() )
		{
			int numb = myQueue2.remove();
			myQueue1.add(numb);
		}
	}
	
	public int pop()
	{
		return myQueue1.remove();
	}
}
