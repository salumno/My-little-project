/*

*/

import java.util.Scanner;
import java.util.Arrays;

public class BinarySearchTest {
	
	public static int binarySearch(int[] arr, int x) {
		int index = -1;
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == x) {
				index = mid;
				break;
			} else {
				if (x > arr[mid]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
		}
		return index;
	}	
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 10);
		}
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("write required number");
		int inx = binarySearch(array, sc.nextInt());
		System.out.println(inx);
	}
}
