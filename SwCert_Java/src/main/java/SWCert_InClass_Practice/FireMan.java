/*
�ҹ���� �ڽ��� ��ġ���� ��/��/��/�� 4 �������� ���� �л� �� �� �ִ�.
�л�Ǵ� ���� 2���� Ÿ���� �ִ�. 
1) A Ÿ��(3X5)
2) B Ÿ��(5X3)
����>
- �ҹ�� 1��� 1���� �л縸 �����ϴ�.
- A, B Ÿ���� �л�� ����̴�.
- ��ֹ��� ������ �ش� ���θ� �л���� �ʴ´�.
- �� �� �ִ� ���� �ִ� ���� ���Ͻÿ�.
�Է�> �ҹ���� �� 2 ~ 5��
# : ��, 1 : �ҹ��, 0 : �����
 */
package SWCert_InClass_Practice;

public class FireMan {
	static int N = 2;	// �ҹ����
	static int[][] map;
	
	static char[] type = new char[5];
	static int[] dir = new int[5];
	static int cnt = 0;
	static void solve(int k, int n)
	{
		if(k == n) {
			System.out.printf("%2d>", ++cnt);
			for(int i = 0; i < k; i++)
			{
				System.out.print("(" + type[i] +"," + dir[i] + ") ");				
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < 4; i++)
		{
			dir[k] = i;
			type[k] = 'A';
			solve(k + 1, n);
			
			type[k] = 'B';
			solve(k + 1, n);
		}
	}
	public static void main(String[] args) {
		solve(0, N);
	}

}
