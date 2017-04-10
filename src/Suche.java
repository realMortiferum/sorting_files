import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.io.FilenameUtils;

/**
 * Übernahme des Ursprungspfades (pfad)
 * <p>
 * Suche nach unterschiedlichen Dateitypen sowie deren Häufigkeit
 * <p>
 * Übernahme der Endungenliste (endungen)
 * <p>
 * Erstellung einer Liste mit allen Pfadverzeichnissen der gewünschten Dateien (bilder)
 * 
 * @author ala
 * @version 0.1
 */

public class Suche {

	List<String> bilder = new ArrayList<String>();
	List<String> dateiendung = new ArrayList<String>();
	List<String> dateiendungonly = new ArrayList<String>();
	List<String> endungen = new ArrayList<String>();
	int d;
	String dattypennumstring;

	public void setVariable(String pfad) throws IOException {

		File dir = new File(pfad);
		Bildsortierung sort = new Bildsortierung();
		endungen = sort.getendungen();
		bilder.clear();
		d = 0;
		int a = sort.geta();
		String dattyp = endungen.get(a);

		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(dattyp);
			}
		});
		for (File f : files) {
			String b = String.valueOf(f);
			bilder.add(b);
			d = d + 1;
		}

	}

	public List<String> getBilder() {
		return bilder;
	}

	public int getD() {
		return d;
	}

	public void listfiles(String pfad) {
		File dir = new File(pfad);
		File[] listOfFiles = dir.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			String c = String.valueOf(listOfFiles[i].getName());
			dateiendung.add(c);
			dateiendungonly.add(FilenameUtils.getExtension(dateiendung.get(i)));
		}
		Set<String> unique = new HashSet<String>(dateiendungonly);
		for (String key : unique) {
			System.out.println("Im Ordner vorhanden " +key + ": "
					+ Collections.frequency(dateiendungonly, key));
		}
	}

	public void mehrereDaten() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Wollen sie mehrere Dateien kopieren? 1/2");
		String dattypen = reader.next();

		while (Integer.parseInt(dattypen) != 1
				&& Integer.parseInt(dattypen) != 2) {
			Scanner reader3 = new Scanner(System.in);
			System.out.println("Ungültige Angabe! 1 oder 2!");
			dattypen = reader3.nextLine();
		}

		if (Integer.parseInt(dattypen) == 1) {
			Scanner reader4 = new Scanner(System.in);
			System.out.println("wie viele Endungen wollen sie angeben?");
			dattypennumstring = reader4.nextLine();
		} else {
			dattypennumstring = "1";
		}
	}

	public int getmehrereDatenint() {
		return Integer.parseInt(dattypennumstring);
	}
}
