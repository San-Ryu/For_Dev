package Java_Basic;

public class Java_0303_print {

	public static void main(String[] args) {
		/*
		 * printf("출력형식", 값1, 값2...)
		 * 
		 * 출력기호
		 * %d:정수
		 * %f:실수
		 * %c:문자
		 * %s:문자열
		 * %b:논리
		 * %% : %
		 *\ :키보드에서 지원하는 문자를 표기할때
		 */
       System.out.printf("%c %b %d\n", 'a', true, 10);
       
       System.out.printf("%.2f\n",4.59);
       System.out.printf("%.1f\n",4.54); //반올림
       //5은 총자릿수 (소수점포함)
       System.out.printf("%5.1f\n",4.54);
       //3%2=1
       System.out.printf("%d%%%d=%d\n",3,2,3%2);
       //당신의 색깔은 "파랑"입니다
       System.out.printf("당신의 색깔은   \"%s\" 입니다\n","파랑");
       
	}//end main()

}//end class