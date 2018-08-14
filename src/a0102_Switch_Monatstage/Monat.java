package a0102_Switch_Monatstage;

public class Monat {
	public static void main (String[] args) {
		String monat = "Januar";
		int tage = tageBerechnenIf(monat);
		System.out.println("Der Monat " + monat + " hat " + tage + " Tage.");
	}

	private static int tageBerechnenIf (String monat) {
		if (monat.equals("Januar"))
			return 31;
		else if (monat.equals("Februar"))
			return 28;
		else if (monat.equals("März"))
			return 31;
		else if (monat.equals("April"))
			return 30;
		else if (monat.equals("Mai"))
			return 31;
		else if (monat.equals("Juni"))
			return 30;
		else if (monat.equals("Juli"))
			return 31;
		else if (monat.equals("August"))
			return 31;
		else if (monat.equals("September"))
			return 30;
		else if (monat.equals("Oktober"))
			return 31;
		else if (monat.equals("November"))
			return 30;
		else if (monat.equals("Dezember"))
			return 31;
		else 
			return -1;
	}
	
	private int tageBerechnenSwitch (String monat) {
		switch(monat) {
		case "Januar":
		case "März":
		case "Mai":
		case "Juli":
		case "August":
		case "Oktober":
		case "Dezember": return 31;
		case "April":
		case "Juni":
		case "September":
		case "November": return 30;
		case "Februar": return 28;
		default: return -1;
		}
	}
}
