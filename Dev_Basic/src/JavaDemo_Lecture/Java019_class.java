package JavaDemo_Lecture;

class Goods{
	String name; //상품명
	int price; //상품 가격
	int numberOfStock; //상품 재고
	int sold; //팔린 수량
	
	public Goods() {
		
	}

	public Goods(String name, int price, int numberOfStock, int sold) {
		this.name = name;
		this.price = price;
		this.numberOfStock = numberOfStock;
		this.sold = sold;
	}
	
	public void prn() {
		System.out.printf("%s %d %d %d\n", name, price, numberOfStock, sold);
	}
	
	
}//end class

public class Java019_class {

	public static void main(String[] args) {
		/*Goods g1=new Goods("Nikon", 400000,30, 50);
		Goods g2=new Goods("Sony",  450000, 20, 35);
		Goods g3=new Goods("FujiFilm", 350000, 10, 25);
		g1.prn();
		g2.prn();
		g3.prn();*/
		
		Goods[] goodArray=new Goods[3];
		goodArray[0]=new Goods("Nikon", 400000,30, 50);
		goodArray[1]=new Goods("Sony",  450000, 20, 35);
		goodArray[2]=new Goods("FujiFilm", 350000, 10, 25);
		
		for(Goods data : goodArray)
			data.prn();
		
	}//end main()

}//end class