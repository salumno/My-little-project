/*

*/

interface Stack {
	void push(int data);
	int pop();
	int peep();
	int size();
}

class ListNode {
	int data;
	ListNode next;
}

class StackArray implements Stack {
	private int top;
	private int[] stackArray;
	private int currentSize;
	
	public StackArray (int size) {
		stackArray = new int[size];
		top = -1;
		currentSize = 0;
	}
	
	public void push (int data) {
		stackArray[++top] = data;
		currentSize++;
	}
	
	public int pop () {
		currentSize--;
		return stackArray[top--];
	}
	
	public int peep () {
		return stackArray[top];
	}
	
	public int size() {
		return currentSize;
	}
}

class LinkedStack implements Stack {
	
	ListNode head = new ListNode();
	int currentSize = 0;
	
	public void push (int data) {
		ListNode newNode = new ListNode();
		newNode.data = data;
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		currentSize++;
	}
	
	public int pop () {
		int value = head.data;
		head = head.next;
		currentSize--;
		return value;
	}
	
	public int peep () {
		return head.data;	
	}
	
	public int size() {
		return currentSize;
	}
}

public class StackTest {
	public static void main (String[] args) {
		Stack myStackArray = new StackArray(5);
		Stack myStackList = new LinkedStack();
		System.out.println("Work with array stack:");
		myStackArray.push(4);
		myStackArray.push(3);
		myStackArray.push(2);
		myStackArray.push(1);
		System.out.println("current top element = " + myStackArray.peep());
		System.out.println("return and remove top element " + myStackArray.pop());
		System.out.println("current top element = " + myStackArray.peep());
		System.out.println("Now stack's size = " + myStackArray.size());
		System.out.println();
		System.out.println("Work with linked stack:");
		myStackList.push(9);
		myStackList.push(7);
		//myStackList.push(8);
		System.out.println("current stack's size = " + myStackList.size());
		System.out.println("current top element = " + myStackList.peep());
		System.out.println("return and remove top element " + myStackList.pop());
		System.out.println("Now stack's size = " + myStackList.size());
		System.out.println("current top element = " + myStackList.peep());
	}
}
