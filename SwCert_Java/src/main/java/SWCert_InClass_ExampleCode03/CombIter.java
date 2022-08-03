package SWCert_InClass_ExampleCode03;

public class CombIter {
	static int[] arr = {10, 20, 30, 40, 50};	
	static int N = arr.length;	
	
	static void Comb()
	{		
		for(int i = 0; i < N - 2; i++)
		{
			for(int j = i + 1; j < N - 1; j++)
			{
				for(int k = j + 1; k < N; k++)
					System.out.printf("%d %d %d\n", arr[i], arr[j], arr[k]);				
			}
		}
	}
	public static void main(String[] args) {		
		Comb();
	}

}
