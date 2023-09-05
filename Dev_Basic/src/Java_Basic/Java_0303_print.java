package Java_Basic;

public class Java_0303_print {

	public static void main(String[] args) {
		/*
		 * printf("출력형식", 값1, 값2...)
		 * 
		 * 지시자 (출력기호)
		 * %d:정수
		 * %f:실수
		 * %c:문자
		 * %s:문자열
		 * %b:논리
		 * %% : %
		 *\ :키보드에서 지원하는 문자를 표기할때
		 */
		// 지시자가 없으면, 뒤에 변수를 나열해줘도 반영되지 않음.
		System.out.printf("Ex01) 변수 출력\n", 'a', true, 10);
		// 지시자가 있어야 해당 변수가 문장에 출력됨
		System.out.printf("%c %b %d\n", 'a', true, 10);
		
		// 소수점 출력
		System.out.printf("Ex02) float 출력 \n");
		System.out.printf("%.2f\n",4.59);
		// 자릿수가 더 적으면 반올림 반영됨
		System.out.printf("%.1f\n",4.59);
		System.out.printf("%.1f\n",4.54);
		// 5은 총자릿수 (소수점포함)
		System.out.printf("%.4f\n",4.54554);
		// %[전체 길이].[소숫점 자릿수]
		// 1) [전체 길이] 부분은 해당 변수의 총 길이를 나타냄
		// 2) [소숫점 자릿수] 부분은 소숫점의 자릿수를 나타냄
		// 3) 그러나 [소숫점 자릿수]가 더 큰 경우, 해당 길이를 맞춤. 
		// Padding(채워질 숫자)는 0으로 지정되어야 하며, 다른 문자(숫자 제외)로 지정시 UnknownFormatConversionException 발생
		System.out.printf("%06.03f\n",4.54); // 04.540
//		System.out.printf("%06.0100f\n",4.54); // 4.5400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
//		System.out.printf("%06.20f\n",4.54); // 4.54000000000000000000
//		System.out.printf("%06.A3f\n",4.54); // UnknownFormatConversionException
		
		// 3 % 2 = 1
		System.out.printf("%d %% %d = %d\n",3,2,3%2);
		
		// 당신의 색깔은 "파랑"입니다
		System.out.printf("당신의 색깔은 \"%s\" 입니다\n","파랑");
       
	}//end main()

}//end class