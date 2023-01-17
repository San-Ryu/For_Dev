/*
 * 연산자(operator)
 *  :어떠한 기능을 수행하는 기호(+,-,*,/,%,>,<,==같다, !=다르다)
 *  
 * 피연산자(operand)
 *  : 연산자의 작업 대상(변수,상수,리터널,수식)
 *  연산자종류
 *  1 산술연산자: +, -, *, /, %
 *  2 비교연산자:>,<,>=,<=,==,!=
 *  3 논리연산자: &&(and), ||(or), !(not)
 *  4 삼항연산자: 조건식 ? 참 : 거짓
 *  5 대입연산자 : =, +=, -=, *=, /=
 *  6 단항연산자 : ++(1씩 증가), --(1씩 감소) 
 */
package JavaDemo_Lecture;

public class Java003_operator {

	public static void main(String[] args) {
		int num=3;
		int res=0;
		//res=res+ ++num;
		res=res+ num++;
		System.out.println(res);
		
	}//end main()

}//end class
