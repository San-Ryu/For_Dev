/*
 * ���(control statement) : ������ �帧�� �������ִ� ����̴�.
 * 1 ����
 *   ���ǹ�:if~else, switch~case
 *   �ݺ��� : for, while, do~while
 *   �׿� : breaK, continue, label
 */

/*
 * if(���ǽ�){
 *   ������ ����;
 *   }else{
 *   ������ ����;
 *   }
 */
package Java_Basic;

public class Java_0501_ControlStatement_If {

	public static void main(String[] args) {
		int num=6;
		if(num%2==0) {
			System.out.printf("%d�� ¦���Դϴ�.\n",num);
		}else {
			System.out.printf("%d�� Ȧ���Դϴ�.\n",num);
		}

	}//end main()

}//end class
