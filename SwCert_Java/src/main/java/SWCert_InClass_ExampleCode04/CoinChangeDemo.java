package SWCert_InClass_ExampleCode04;

public class CoinChangeDemo {
	static int[] coin = new int[]{1, 4, 6};
	static int[] choices = new int[100];
	static int min = 0xfffff;
	
	public static void coinChange(int k, int money)
	{
		if(min <= k) return;
		
		if(money == 0)
		{
			min = k;
			System.out.printf("µ¿Àü¼ö = %d> ", k);
			for(int i = 0; i < k; i++)
				System.out.print(choices[i] + " ");
			System.out.println();
			return;
		}
		for(int i = 0; i < coin.length; i++)
		{
			if(money < coin[i]) continue;
			
			choices[k] = coin[i];
			coinChange(k + 1, money - coin[i]);
		}
		
	}
	public static void main(String[] args) {
		
		coinChange(0, 8);
	}

}
