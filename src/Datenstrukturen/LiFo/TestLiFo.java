package Datenstrukturen.LiFo;

public class TestLiFo {
	public static void main (String[] args) {
		LiFo l =new LiFo();
		l.push("Student");
		l.push("Marius");
		l.push("Berlinghof");
		System.out.println(l.pop());
		System.out.println(l.pop());			System.out.println(l.pop());
		System.out.println(l.pop());
		System.out.println(l.pop());
	}
	
}
