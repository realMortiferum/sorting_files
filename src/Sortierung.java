import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
/**
 * Übernahme der zu Kopierenden Dateiverzeichnisse (bilder)
 * <p>
 * Auslesen des letzten Änderungsdatums (in den meisten Fällen das Aufnahmedatum für Bilder)
 * <p>
 * Erstellen einer Liste (bilderdatum), in denen das Datum zur jeweiligen Datei korrespondiert
 * 
 * @author ala
 * @version 0.1
 */
public class Sortierung {
	List<String> bilder = new ArrayList<String>();
	List<String> bilderdatum = new ArrayList<String>();
	int d;
	int c;
	Path p;
	String datum;

	public void Sort() throws IOException {

		Bildsortierung jpg = new Bildsortierung();
		List<String> bilder = new ArrayList<String>();
		bilder = jpg.getBilder();

		for (int c = 0; c < bilder.size(); c++) {
			Path p = Paths.get(bilder.get(c));
			BasicFileAttributes attrs = Files.readAttributes(p,
					BasicFileAttributes.class);
			datum = String.valueOf(attrs.lastModifiedTime());
			bilderdatum.add(datum);
		}

	}

	public List<String> getBilderdatum() {
		return bilderdatum;
	}
}
