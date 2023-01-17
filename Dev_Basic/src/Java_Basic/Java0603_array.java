package Java_Basic;

public class Java0603_array {

	public static void main(String[] args) {
		//초기값을 할당하면서 배열을 생성할때는  배열의 크기를 명시하면 안됨
		int[] data=new int[] {10,20,30};
		/*for(변수선언 : 배열,컬렉션) {
			수행할 문장;
		}*/
		
		for(int element : data )
			System.out.println(element);

	}//end main()

}//end class
