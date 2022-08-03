package SWCert_InClass_ExampleCode09_Library;

import java.util.Arrays;

public class BinarySearchDemo {
	
	public static void main(String[] args)
	{
		int[] arr = new int[]{3, 17, 29, 25, 16, 77, 12, 8, 62, 2, 7, 33, 45, 19};
		
		Arrays.sort(arr);	
	
		for(int val: arr)
			System.out.print(val + " ");
		System.out.println();
		System.out.println("45 => " + Arrays.binarySearch(arr, 45)); // �ε���
		System.out.println("15 => " + Arrays.binarySearch(arr, 15)); // ����
	}
}
