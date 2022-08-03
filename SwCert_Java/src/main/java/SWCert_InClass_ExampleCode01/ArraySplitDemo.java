package SWCert_InClass_ExampleCode01;

public class ArraySplitDemo {
	static int N = 10;
	static int[] arr = new int[N];
	static int[][] map = new int[N][N];

	static void divideArr(int n) {

		for (int i = 0; i < n - 2; i++)
		{
			for(int j = i + 1; j < n - 1; j++)
			{
				for (int k = 0; k <= i; k++)
					arr[k] = 1;

				for (int k = i + 1; k <= j; k++)
					arr[k] = 2;

				for (int k = j + 1; k < n; k++)
					arr[k] = 3;

				// arr[] 출력
				for (int k = 0; k < n; k++)
					System.out.print(arr[k]);
				System.out.println();
			}
		}
	}

	static void divideRect(int n) {

		for (int i = 0; i < n - 1; i++)
		{
			for (int j = 0; j < n - 1; j++)
			{
				// 1번 사각영역
				for (int r = 0; r < n; r++)
					for (int c = 0; c <= i; c++)
						map[r][c] = 1;

				// 2번 사각 영역
				for (int r = 0; r <= j; r++)
					for (int c = i + 1; c < n; c++)
						map[r][c] = 2;

				// 3번 사각 영역
				for (int r = j + 1; r < n; r++)
					for (int c = i + 1; c < n; c++)
						map[r][c] = 3;

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						System.out.print(map[r][c]);
					}
					System.out.println();
				}
				System.out.println("--------------------------");
			}
		}
	}

	public static void main(String[] args) {
		divideArr(7);
		//divideRect(5);
	}

}
