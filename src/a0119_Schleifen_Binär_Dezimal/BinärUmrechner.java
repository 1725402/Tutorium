package a0119_Schleifen_Binär_Dezimal;

public class BinärUmrechner {
	public static void main (String [] args) {
		System.out.println(inDezimal("110101101"));
	}
	 private static int inDezimal(String binär) {
		 char[] zahlen = binär.toCharArray();
		 int ergebnis = 0;
		 int counter = 0;
		 for (int i = zahlen.length-1; i>= 0; i--) {
			 int temp = 0;
			 switch (zahlen[counter]) {
			 case '0': break;
			 case '1': temp = 1;
			 }
			 System.out.println("i: " + i + " zahl: " + zahlen[counter]);
			 int zwischenergebnis = temp* (int)(Math.pow(2, i));
			 System.out.println(zwischenergebnis);
			 ergebnis += zwischenergebnis;
			 counter ++;
		 }
		 return ergebnis;
	 }
}
