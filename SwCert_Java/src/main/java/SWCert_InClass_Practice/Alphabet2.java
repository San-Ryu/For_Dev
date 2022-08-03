package SWCert_InClass_Practice;

public class Alphabet2 {
	static String str = "NBACPBARBCYACMS";
	static int[] memo = new int[str.length()];
	
	static int findStr(int cur)
	{
		if(str.charAt(cur) == 'A') return memo[cur] = 1;
		if(memo[cur] != -1) return memo[cur];
		
		char prev = (char)(str.charAt(cur) - 1);
		int ret = 0;
		for(int i = cur - 1; i >= 0; i--)
		{
			if(str.charAt(i) == prev)
				ret += findStr(i);
		}
		return memo[cur] = ret;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < str.length(); i++)
			memo[i] = -1;
		int ret = 0;
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 'C')
			{
				ret += findStr(i);
			}
		}
		System.out.println("cnt = " + ret);
		printMemo();
	}
	static void printMemo() {
		for(int i = 0; i < str.length(); i++)
			System.out.printf("%2c|", str.charAt(i));
		System.out.printf("\n----------------------------------------------\n");
		for(int i = 0; i < str.length(); i++)
			System.out.printf("%2d|", i);
		System.out.printf("\n----------------------------------------------\n");
		for(int i = 0; i < str.length(); i++)
			System.out.printf("%2d|", memo[i]);
	}
}
