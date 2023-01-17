package Java_Basic;

//사용자 데이터 타입
class Person {
	// 멤버변수
	String name;
	int age;
	char gen;

	public void eat() {
		System.out.println("eat");
	}//end eat()
}//end Person

public class Java0701_class {

	public static void main(String[] args) {
       int num;
       num=3;
       Person ps; //객체 선언
       ps=new Person(); //객체생성
       
       //객체변수.멤버변수
       ps.name="홍길동";
       ps.age=30;
       ps.gen='남';       
       System.out.printf("%s %d %c\n", ps.name, ps.age, ps.gen);
       
       Person pn=new Person();
       pn.name="이영희";
       pn.age=25;
       pn.gen='여';
       System.out.printf("%s %d %c\n", pn.name, pn.age, pn.gen);
       
	}// end main()

}// end class