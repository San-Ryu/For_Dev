/*	�ִ밪 ���ϱ�
[����]
������ �ڷ���� ����� �迭���� �ִ밪�� ���ϴ� ��� �Լ��� �ۼ��Ͻÿ�.
 */
package SWCert_InClass;

public class Day1_MaximumNumber {
	static int arr[] = {16, 12, 18, 22, 53, 94, 54, 83, 57, 63};
	
	public static int getMax(int lo, int hi) {
		if(lo == hi)	return arr[lo];
		int ret = getMax(lo, hi - 1);
		return ret > arr[hi] ? ret : arr[hi];
	}	//	End getMax
	
	public static void PrintHello(int i, int n, int deg) {
		System.out.println("Max = " + getMax(0, arr.length));
		
	}	//	End Main
}	//	End	Class 