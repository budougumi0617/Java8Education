package main.java.digitalclock;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PrefsData {
	private Preferences prefs;

	public PrefsData() {
		prefs = Preferences.userNodeForPackage(this.getClass());
	}

	public void intSave(String key, int data) {
		System.out.println("Save int Data : " + key);
		try {
			prefs.putInt(key, data);
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public int intLoad(String key, int def) {
		System.out.println("Get int Data :" + key);
		return prefs.getInt(key, def);
	}
}
