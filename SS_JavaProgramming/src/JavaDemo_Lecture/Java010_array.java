package JavaDemo_Lecture;

public class Java010_array {

	public static void main(String[] args) {
		//int[][] num=new int[3][2]; //3행 2열
		int[][] num=new int[][] {{1,2},{3,4},{5,6}};
		
		//2차원배열에서 length은 행의 크기를 리턴
		for(int i=0; i<num.length; i++) {
			//2차원배열에서 num[행인덱스].length은 각행의 열의 크기 리턴
			for(int j=0; j<num[i].length; j++) {
			  System.out.print(num[i][j]);	
			}		
			System.out.println();
		}

	}//end main()

}//end class
