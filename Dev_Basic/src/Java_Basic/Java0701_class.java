package Java_Basic;

//����� ������ Ÿ��
class Person {
	// �������
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
       Person ps; //��ü ����
       ps=new Person(); //��ü����
       
       //��ü����.�������
       ps.name="ȫ�浿";
       ps.age=30;
       ps.gen='��';       
       System.out.printf("%s %d %c\n", ps.name, ps.age, ps.gen);
       
       Person pn=new Person();
       pn.name="�̿���";
       pn.age=25;
       pn.gen='��';
       System.out.printf("%s %d %c\n", pn.name, pn.age, pn.gen);
       
	}// end main()

}// end class