package JavaDemo_Lecture;

public class Java010_array {

	public static void main(String[] args) {
		//int[][] num=new int[3][2]; //3�� 2��
		int[][] num=new int[][] {{1,2},{3,4},{5,6}};
		
		//2�����迭���� length�� ���� ũ�⸦ ����
		for(int i=0; i<num.length; i++) {
			//2�����迭���� num[���ε���].length�� ������ ���� ũ�� ����
			for(int j=0; j<num[i].length; j++) {
			  System.out.print(num[i][j]);	
			}		
			System.out.println();
		}

	}//end main()

}//end class
