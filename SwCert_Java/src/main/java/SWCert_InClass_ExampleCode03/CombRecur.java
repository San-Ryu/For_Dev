package SWCert_InClass_ExampleCode03;

public class CombRecur {
	static int[] arr = {10, 20, 30, 40, 50};	
	static int N = arr.length;
	static int[] pick = new int[N];	
	
	static void comb(int k, int r, int start){
		if(k == r){
			for(int i = 0; i < r; i++)
				System.out.printf(arr[pick[i]] + " ");
			System.out.println();
			return;
		}
		for(int i = start; i < N; i++)
		{
			pick[k] = i;
			comb(k + 1, r, i + 1);
		}
	}
	public static void main(String[] args) {		
		comb(0, 3, 0);
	}
}
