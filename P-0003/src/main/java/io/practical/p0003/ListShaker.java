package io.practical.p0003;

import java.util.List;

// Come on, list, and shake your booty !!!
public class ListShaker {

	private List<Integer> myList;
	
	public ListShaker(List<Integer> myList) {
		this.myList = myList;
	}
	
	public void shakeList() {
		for (int i = 0; i < 500_000; i++)
		{
			// we insert in the list the value of the counter
			myList.add(i);
		}
		for (int i = 0; i < 10_000; i++)
		{
			// we remove the element which index is the counter (and not the element which value is the counter, although it's the same)
			myList.remove(i);
		}
		for (int i : myList) {
			//pretend to use i
			Math.log(i);
		}
	}
	
}
