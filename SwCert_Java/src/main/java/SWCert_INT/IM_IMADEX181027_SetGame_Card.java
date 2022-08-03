/*	Set 게임
[문제]
여러 장의 카드를 섞어 세트 게임을 진행하려 한다.
세트 게임은 
 */
package SWCert_INT;

import java.io.*;
import java.util.*;

public class IM_IMADEX181027_SetGame_Card {
	static int N;
	static String Card[];
	static int Ans;
	
	static int Cnt;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (IM_IMADEX181027_SetGame_Card).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
		//	Init. & Ipt.
			Ans = Cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			Card = new String[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Card[i] = st.nextToken();
			}
			
			boolean[] Stat = new boolean[N];
		//	Init. & Ipt.
			
		//	Oper
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					for(int k = j + 1; k < N; k++) {
						for(int l = 0; l < 4; l++) {
							if((Card[i].charAt(l) == Card[j].charAt(l)) && (Card[j].charAt(l) == Card[k].charAt(l)))	Cnt++;
							
							else if((Card[i].charAt(l) != Card[j].charAt(l)) && (Card[j].charAt(l) != Card[k].charAt(l)) && (Card[k].charAt(l) != Card[i].charAt(l)))	Cnt++;

							if(Cnt == 4)	Ans++;
						}
						Cnt = 0;
					}
				}
			}
		//	Oper
			
		// Opt
			System.out.println("#" + tc + " " + Ans);
			for(int i = 0; i < N; i++) {
				System.out.println(Card[i]);
			}
		// Opt
		}	//	End Test Case
	}	//	End Main
}	//	End Class
