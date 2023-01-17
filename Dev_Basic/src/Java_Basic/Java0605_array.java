package Java_Basic;

public class Java0605_array {

	public static void main(String[] args) {
		//가변배열 제공하는 이유: 메모리 손실을 최소화 하기 위해서
		int[][] num=new int[3][];
		num[0]=new int[2];// 0행의 열의 크기 2
		num[1]=new int[3]; // 1행의 열의크기3
		num[2]=new int[5]; //2행의 열의크기 5
		
		num=new int[][] {{1,2},{3,4,5},{6,7,8,9,10}};
		
		for(int i=0; i<num.length; i++) {
			for(int j=0; j<num[i].length; j++) {
				System.out.printf("%3d",num[i][j]);
			}
			System.out.println();
		}
				
	}//end main()

}//end class
