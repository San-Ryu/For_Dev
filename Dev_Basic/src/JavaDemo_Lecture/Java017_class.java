package JavaDemo_Lecture;

class Employee{
	String name;
	String dept;
	int salary;
	
	public Employee() { //b
	 this("È«±æµ¿","º¸·ù",3000); //c
	} //i

	public Employee(String name, String dept, int salary) {	 //2  d	
		this.name = name; //3  e
		this.dept = dept; //4  f
		this.salary = salary;//5 g
	}//6 h
	
	public void prn() { //8  k
		System.out.printf("%s %s %d\n", name, dept, salary); //9  l
	} //10  m
}//end class

public class Java017_class {

	public static void main(String[] args) {
		Employee emp=new Employee("¿ëÆÈÀÌ","±âÈ¹",5000); //1
		emp.prn(); //7
		
		Employee ems=new Employee(); //a
		ems.prn(); //j
		
	}//end main() //10  n

}//end class







