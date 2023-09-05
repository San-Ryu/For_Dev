/*
 * 제어문(control statement) : 문장의 흐름을 제어해주는 기능이다.
 * 1 종류
 *   조건문:if~else, switch~case
 *   반복문 : for, while, do~while
 *   그외 : breaK, continue, label
 */

/*
 * if(조건식){
 *   수행할 문장;
 *   }else{
 *   수행할 문장;
 *   }
 */
package Java_Basic;

public class Java_0501_ControlStatement_If {

	public static void main(String[] args) {
		int num=6;
		if(num%2==0) {
			System.out.printf("%d는 짝수입니다.\n",num);
		}else {
			System.out.printf("%d는 홀수입니다.\n",num);
		}

	}//end main()

}//end class
