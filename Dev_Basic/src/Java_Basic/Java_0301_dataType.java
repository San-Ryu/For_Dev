/*
 * 리터널(literal) : 그 자체의 값(1,2,3,..'a','b','c'...,true, false)
 * 변수(variable) : 하나의 값을 저장하기 위한 메모리 공간
 * 데이터 타입(data type) : 값의 종류와 메모리 크기를 결정
 * 자바에서 제공하는 데이터 타입
 * 1 기본 데이터 타입(primitive data type)
 *   byte(1), short(2), int(4), long(8)=>정수
 *   float(4), double(8) => 실수
 *   char(2) => 문자
 *   boolean(1) => 논리
 * 2 참조 데이터 타입 (reference data type)
 *   배열(array), 클래스(class), 인터페이스(interface)
 *   
 *   시스템에서 인식하는 데이터 타입 크기
 *   byte<short,char<int<long<float<double
 */
package Java_Basic;

public class Java_0301_dataType {

	//현재 프로그램을 실행할때 제일 먼저 호출되는 메소드 이다.
	public static void main(String[] args) {
		//1 데이터 타입으로 메모리 공간을 확보한다.
		//2 메모리 공간을 관리해줄 변수를 선언한다.
		//3 메모리에 값을 할당한다.
		int data=3;
		
		System.out.println(data);
		
		double num=4.5;
		//캐스팅 타입선언 : 명시적 형변환
		int x=(int)num;
		System.out.println(x);
		
		//캐스팅 타입 생략 : 묵시적 형변환
		long y=data;
		System.out.println(y);
		
		/*
		 * 유니코드
		 * 'A' => 65
		 * 'a' => 97
		 * 'o' => 48
		 */	
		
	}//end main()

}//end class