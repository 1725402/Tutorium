package SchlagDeinTeam;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
}
