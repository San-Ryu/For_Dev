/*
 * 변수 : 하나의 값을 저장하기 위한 메모리 공간
 * 배열
 *   1. 같은 데이터 타입의 여러 변수를 하나의 묶음으로 다루는 것이다.
 *   2. 많은 양의 값(데이터)를 다룰 때 유용하다.
 *   3. 배열의 각 요소는 연속적이다.
 */
package Java_Basic;

public class Java0601_array {

	public static void main(String[] args) {
		int num[] =new int[3];
		num[0]=10;
		num[1]=20;
		num[2]=30;
		
		//length : 배열의 크기
		for(int i=0; i<num.length;i++) {
			System.out.println(num[i]);
		}	

	}//end main()

}//end class