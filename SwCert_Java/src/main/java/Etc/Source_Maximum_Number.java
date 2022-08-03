package Etc;

/*

12
1 0 2 200 -1000000 300 82019 1000 2000 324389 1000000 98765

3
0 -200 1 

5
-200 0 1 2 3

8
100 300 82019 1000000 1 324389 12345 98765

5
1 2 3 4 5
 */
import java.io.*;
import java.util.*;

public class Source_Maximum_Number{
	static int N;
	static int Num[];
	static int Max[];

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws Exception{
		StringTokenizer st = null;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Num = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)	Num[i] = Integer.parseInt(st.nextToken());
			Max = new int[N];

			Max[0] = Num[0];
			bw.write(Max[0] + " ");
			for(int i = 1; i < N; i++){
				Max[i] = Math.max(Max[i - 1], Num[i]);
				
				if(i == (N - 1))	bw.write(Max[i] + "");
		        else	bw.write(Max[i] + " ");
			}
			
			br.close();
			bw.flush();
			bw.close();
	}
}