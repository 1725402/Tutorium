package SchlagDeinTeam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class persistenzSerialisiert {
	
	private File öffnen (String fullName) {
		File file = null;
		file = new File ((String)(fullName + ".sdr"));
		return file;
	}
	
	public Object laden (String fullName) throws SdTException {
		File file = öffnen(fullName);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object objekt = null;
		try {
			fis = new FileInputStream (file);
			ois = new ObjectInputStream (fis);
			objekt = ois.readObject();
		} catch (FileNotFoundException e) {
			throw new SdTException ("Ladefehler - Datei konnte nicht gefunden werden");
		} catch (IOException e) {
			throw new SdTException ("Ladefehler - Datei konnte nicht gelesen werden");
		} catch (ClassNotFoundException e) {
			throw new SdTException ("Ladefehler - Ungültige Speicherinformation");
		}finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				throw new SdTException("Ladefehler - Streams konnten nicht geschlossen werden");
			}
			
		}
		return objekt;
	}
	
	public void speichern (String fullName, Object object) throws SdTException {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		File file = öffnen (fullName);
		try {
			fos = new FileOutputStream (file);
			oos = new ObjectOutputStream (fos);
			oos.writeObject(object);
		} catch (Exception e) {
			new SdTException ("");
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				 throw new SdTException ("Speicherfehler - FileOutputStream konnte nicht geschlossen werden");
			}
			try {
				oos.close();
			} catch (IOException e) {
				throw new SdTException ("Speicherfehler - ObjectOutputStream konnte nicht geschlossen werden");
			}
		}
	}
	
	public Object ladenCSV (String fullName) throws SdTException {
		File file = öffnen(fullName);
		FileInputStream fis = null;
		DataInputStream dis = null;
		Object objekt = null;
		try {
			fis = new FileInputStream (file);
			dis = new DataInputStream (fis);
			objekt = dis.readUTF();
		} catch (FileNotFoundException e) {
			throw new SdTException ("Ladefehler - Datei konnte nicht gefunden werden");
		} catch (IOException e) {
			throw new SdTException ("Ladefehler - Datei konnte nicht gelesen werden");
		}finally {
			try {
				fis.close();
				dis.close();
			} catch (IOException e) {
				throw new SdTException("Ladefehler - Streams konnten nicht geschlossen werden");
			}
			
		}
		return objekt;
	}
	
	public void speichernCSV (String fullName, ArrayList<String> object) throws SdTException {
		DataOutputStream dos = null;
		FileOutputStream fos = null;
		File file = öffnen (fullName);
		StringBuilder liste = new StringBuilder();
		for (String t : object) {
			String[] person = t.split(";");
			String gender,vorname,nachname,alter;
			vorname = person[0];
			nachname = person [1];
			alter = person[2];
			gender = person[3];
			liste.append(vorname+ ";" + nachname + ";" + alter + ";" + gender + "---");
		}
		try {
			fos = new FileOutputStream (file);
			dos = new DataOutputStream (fos);
			dos.writeUTF(liste.toString());
			dos.flush();
		} catch (Exception e) {
			new SdTException ("Speicherfehler - Daten konnten nicht gespeichert werden");
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				 throw new SdTException ("Speicherfehler - FileOutputStream konnte nicht geschlossen werden");
			}
			try {
				dos.close();
			} catch (IOException e) {
				throw new SdTException ("Speicherfehler - ObjectOutputStream konnte nicht geschlossen werden");
			}
		}
	}
}
