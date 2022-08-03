/*	최대값 구하기
[문제]
정수형 자료들이 저장된 배열에서 최대값을 구하는 재귀 함수를 작성하시오.
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