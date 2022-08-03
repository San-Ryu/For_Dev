package SWCert_InClass_Practice;

public class Alphabet1 {
	static String str = "NBACPBARBCYACMS";
	static int[] choices = new int[3];
	static int cnt = 0;
	static void findStr(int cur)
	{
		if(str.charAt(cur) == 'A') {
			cnt++;
			return;
		}		
		char prev = (char)(str.charAt(cur) - 1);
		for(int i = cur - 1; i >= 0; i--)
		{
			if(str.charAt(i) == prev)
				findStr(i);
		}
	}

	static void printStr()
	{
		for(int i = 0; i < str.length(); i++)
		{
			System.out.printf("%3d", i);
		}
		System.out.println();
		for(int i = 0; i < str.length(); i++)
		{
			System.out.printf("%3c", str.charAt(i));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		printStr();
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 'C')
			{
				//findStr(i);
				choices[0] = i;
				findStr(1, i);				
			}
		}
		System.out.println("cnt = " + cnt);
	}
	
	static void findStr(int k, int cur)
	{
		if(str.charAt(cur) == 'A') {
			cnt++;			
			for(int i = k - 1; i >= 0; i--)
				System.out.print(choices[i] + ", ");
			System.out.println();
			return;
		}		
		char prev = (char)(str.charAt(cur) - 1);
		for(int i = cur - 1; i >= 0; i--)
		{
			if(str.charAt(i) == prev)
			{
				choices[k] = i;
				findStr(k + 1, i);
			}
		}
	}
}
