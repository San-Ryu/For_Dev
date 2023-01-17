/*
 * show()�޼ҵ带 �Ʒ��� ���� ����� �ǵ��� �����ϼ���.
 * 
 * [������]
 * �뷡 ����:Dansing Queen
 * ����:ABBA
 * �ٹ�:Arrival
 * �۰:Benny Andersson,Bjorn Ulvaeus
 * �⵵:1977
 * Ʈ�� ��ȣ:2
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
		System.out.println("�뷡����:"+title);
		System.out.println("����:"+artist);
		System.out.println("�ٹ�:"+album);
		System.out.print("�۰:");
		for(int i=0; i<composer.length;i++) {
			String chk=i<composer.length-1?",":"\n";
			System.out.printf("%s%s",composer[i],chk);
		}
		
		System.out.println("�⵵:"+year);
		System.out.println("Ʈ����ȣ:"+track);
	}// end show( )
}// end class

public class Java0707_class {

	public static void main(String[] args) {
		Song s = new Song("Dansing Queen", "ABBA", "Arrival", new String[] { "Benny Andersson", "Bjorn Ulvaeus" }, 1977,
				2);
		s.show();
	}
}
