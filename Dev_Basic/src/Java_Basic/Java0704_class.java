/*
 * 생성자(constructor)
 * 1 멤버변수를 초기화하기 위한 목적으로 사용한다.(한번만 호출)
 * 2 클래스명과 같다.
 * 3 클래스는 한개 이상의 생성자를 갖는다.
 * 4 생성자는 리턴값이 없다.
 * 5 클래스에 생성자가 정의되여 있지않으면 JVM에서 기본생성자를 제공한다.
 * 6 기본생성자는 클래스의 접근제어자를 그대로 사용한다.
 */
package Java_Basic;

class HandPhone{
	//멤버변수
	String name;
	String number;
	
	//자바가상머신(JVM)에서 제공하는 기본생성자
	//생성자가 정의되여 있지 않으면 JVM에서 기본생성자를 제공한다.
	HandPhone(){}
	
	HandPhone(String n, String b){
		name=n;
		number=b;
	}
	
	void prn() {
		System.out.printf("%s %s\n",name,number);
	}//end prn()
	
}//end class

public class Java0704_class {

	public static void main(String[] args) {
		HandPhone ph=new HandPhone();
		ph.name="홍길동";
		ph.number="010-2542-5293";
		ph.prn();
		
		HandPhone pe=new HandPhone("이영희", "010-5235-9223");
		pe.prn();
	}//end main()

}//end class