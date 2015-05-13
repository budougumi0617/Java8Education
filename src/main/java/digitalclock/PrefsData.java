package main.java.digitalclock;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PrefsData {
	private Preferences prefs;

	public PrefsData() {
		prefs = Preferences.userNodeForPackage(this.getClass());
	}

	public void saveInt(String key, int data) {
		System.out.println("Save : key = " + key + " value = " + data);
		try {
			prefs.putInt(key, data);
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public void saveString(String key, String data) {
		System.out.println("Save : key = " + key + " value = " + data);
		try {
			prefs.put(key, data);
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public void saveDouble(String key, double data) {
		System.out.println("Save : key = " + key + " value = " + data);
		try {
			prefs.putDouble(key, data);
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public int loadInt(String key, int def) {
		int result = prefs.getInt(key, def);
		System.out.println("load : key = " + key + " value = " + result);
		return result;
	}

	public String loadString(String key, String def) {
		String result = prefs.get(key, def);
		System.out.println("load : key = " + key + " value = " + result);
		return result;
	}

	public double loadDouble(String key, double def) {
		double result = prefs.getDouble(key, def);
		System.out.println("load : key = " + key + " value = " + result);
		return result;
	}

}
