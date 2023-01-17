/*
 * show()메소드를 아래와 같이 출력이 되도록 구현하세요.
 * 
 * [실행결과]
 * 노래 제목:Dansing Queen
 * 가수:ABBA
 * 앨범:Arrival
 * 작곡가:Benny Andersson,Bjorn Ulvaeus
 * 년도:1977
 * 트랙 번호:2
 */
package Java_Basic;

class Song {
	String title;
	String artist;
	String album;
	String[] composer;
	int year;
	int track;

	public Song() {
	}

	public Song(String title, String artist, String album, String[] composer, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
	}

	public void show() {
		System.out.println("노래제목:"+title);
		System.out.println("가수:"+artist);
		System.out.println("앨범:"+album);
		System.out.print("작곡가:");
		for(int i=0; i<composer.length;i++) {
			String chk=i<composer.length-1?",":"\n";
			System.out.printf("%s%s",composer[i],chk);
		}
		
		System.out.println("년도:"+year);
		System.out.println("트랙번호:"+track);
	}// end show( )
}// end class

public class Java0707_class {

	public static void main(String[] args) {
		Song s = new Song("Dansing Queen", "ABBA", "Arrival", new String[] { "Benny Andersson", "Bjorn Ulvaeus" }, 1977,
				2);
		s.show();
	}
}
