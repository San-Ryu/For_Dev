/*
 * this: ��ü �ڽ��� �ǹ��Ѵ�.
 * this.�������
 * this.�޼ҵ�()
 * this( ) : ������
 */
package JavaDemo_Lecture;

class Product{
	String code;
	String pname;
	int cnt;
	
	public Product() {}
	public Product(String code, String pname, int cnt) {
		this.code=code;
		this.pname=pname;
		this.cnt=cnt;		
	}
	
	public void prn() {
		System.out.printf("%s %s %d\n", code, pname, cnt);
	}
}//end class

public class Java016_class {

	public static void main(String[] args) {
		Product pt=new Product("a001","����", 2);
		pt.prn();
	}//end main()

}//end class