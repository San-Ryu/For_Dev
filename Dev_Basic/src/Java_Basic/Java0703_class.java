package Java_Basic;

class MemberVar{
	//멤버변수
	byte var_byte; //0
	short var_short; //0
	int var_int; //0
	long var_long; //0L
	float var_float; //0.0F
	double var_double; //0.0
	char var_char; // \u0000
	int[] num; //null
}//end class

public class Java0703_class {

	public static void main(String[] args) {
		//지역변수-기본값이 제공안됨
		int num;		
		//System.out.println(num);		
		MemberVar mv=new MemberVar();
		System.out.printf("var_byte:%d\n",mv.var_byte); //0
		System.out.printf("var_short:%d\n", mv.var_short);//0
		System.out.printf("var_int:%d\n", mv.var_int);//0
		System.out.printf("var_long:%d\n", mv.var_long);//0		
		System.out.printf("var_float:%f\n", mv.var_float);//0.0
		System.out.printf("var_double:%f\n", mv.var_double);//0.0
		System.out.printf("var_char:%c\n", mv.var_char);// \u0000
		System.out.printf("var_num:%s\n", mv.num);	//null	

	}//end main()

}//end class