/*
 * ������(operator)
 *  :��� ����� �����ϴ� ��ȣ(+,-,*,/,%,>,<,==����, !=�ٸ���)
 *  
 * �ǿ�����(operand)
 *  : �������� �۾� ���(����,���,���ͳ�,����)
 *  ����������
 *  1 ���������: +, -, *, /, %
 *  2 �񱳿�����:>,<,>=,<=,==,!=
 *  3 ��������: &&(and), ||(or), !(not)
 *  4 ���׿�����: ���ǽ� ? �� : ����
 *  5 ���Կ����� : =, +=, -=, *=, /=
 *  6 ���׿����� : ++(1�� ����), --(1�� ����) 
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
