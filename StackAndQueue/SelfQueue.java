package data.structures;

import java.util.*;

public class SelfQueue {
	
	private Stack<Integer> myStack1 = new Stack<Integer>();
	private Stack<Integer> myStack2 = new Stack<Integer>();
	
	public void add( int number )
	{
		while( !myStack1.empty() )
		{
			int numb = myStack1.pop();
			myStack2.push(numb);
		}
		
		myStack1.push(number);
		
		while( !myStack2.empty() )
		{
			int numb = myStack2.pop();
			myStack1.push(numb);
		}
	}
	
	public int remove()
	{
		return myStack1.pop();
	}

}
