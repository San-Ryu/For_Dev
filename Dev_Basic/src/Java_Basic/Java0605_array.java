package Java_Basic;

public class Java0605_array {

	public static void main(String[] args) {
		//�����迭 �����ϴ� ����: �޸� �ս��� �ּ�ȭ �ϱ� ���ؼ�
		int[][] num=new int[3][];
		num[0]=new int[2];// 0���� ���� ũ�� 2
		num[1]=new int[3]; // 1���� ����ũ��3
		num[2]=new int[5]; //2���� ����ũ�� 5
		
		num=new int[][] {{1,2},{3,4,5},{6,7,8,9,10}};
		
		for(int i=0; i<num.length; i++) {
			for(int j=0; j<num[i].length; j++) {
				System.out.printf("%3d",num[i][j]);
			}
			System.out.println();
		}
				
	}//end main()

}//end class
