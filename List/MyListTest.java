/*

*/

import java.util.Scanner;

class ListNode {
	int data;
	ListNode next;
}

class List {
	private ListNode head;
	private ListNode tail;
	
	void addBack (int data) {
		ListNode newNode = new ListNode();
		newNode.data = data;
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	void addFront (int data) {
		ListNode newNode = new ListNode();
		newNode.data = data;
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	void printList () {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		ListNode currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	void removeNode (int data) { // Remove element of list which equals to user's data.
		if (head == null) {      
			return;
		}
		if (head.data == data) {
			head = head.next;
			return;
		}
		ListNode currentNode = head;
		while (currentNode.next != null) {
			if (currentNode.next.data == data) {
				if (currentNode.next == tail) {
					tail = currentNode;
				}
				currentNode.next = currentNode.next.next;
				return;
			}
			currentNode = currentNode.next;
		}
		System.out.println("That number doesn't exist");
	}
	
	void removeNode2 (int data) {
		if (head == null) {      
			return;
		}
		if (head.data == data) {
			head = head.next;
			return;
		}
		ListNode currentNode = head.next;
		ListNode prev = head;
		while (currentNode != null) {
			if (currentNode.data == data) {
				if (currentNode == tail) {
					tail = prev;
				}
				prev.next = currentNode.next;
				return;
			}
			prev = currentNode;
			currentNode = currentNode.next;
		}
		System.out.println("That number doesn't exist");
	}
	
	void backwardsList () {
		ListNode currentNode = head.next;
		ListNode prev = head;
		ListNode nextNode = new ListNode();;
		while (currentNode != tail) {
			nextNode = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = nextNode;
		}
		currentNode.next = prev;
		tail = head;
		head = currentNode;
		tail.next = null;
	}
	
	void minAndMaxShuffle () {
		ListNode maxNode = new ListNode();
		maxNode.data = Integer.MIN_VALUE;
		ListNode minNode = new ListNode();
		minNode.data = Integer.MAX_VALUE;
		ListNode currentNode = head;
		while (currentNode != null) {
			if (currentNode.data > maxNode.data) {
				maxNode = currentNode;
			}
			if (currentNode.data < minNode.data) {
				minNode = currentNode;
			}
			currentNode = currentNode.next;
		}
		int temp = maxNode.data;
		maxNode.data = minNode.data;
		minNode.data = temp;
	}
	
	void printBackwardsList () {
		
	}

}

public class MyListTest {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		List myList = new List();
		myList.addBack(5);
		myList.addBack(500);
		myList.addBack(51);
		myList.addBack(7);
		myList.addBack(1);
		myList.addFront(131);
		myList.printList();
		//System.out.println("Какое число мы удалим из списка?");
		//myList.removeNode2(sc.nextInt());
		//myList.printList();
		//System.out.println("Backwards time!");
		//myList.backwardsList();
		System.out.println("Shuffle time!");
		myList.minAndMaxShuffle();
		myList.printList();
		System.out.println("print backwards list without backwardsList method");
		myList.printBackwardsList();
	}
}
