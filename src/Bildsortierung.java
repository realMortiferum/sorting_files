import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Haupklasse, welche Input annimmt und an die anderen Klassen weitergibt
 * @author ala
 * @version 0.1
 */

public class Bildsortierung {

	public String pfad;
	static List<String> bilder = new ArrayList<String>();
	static List<String> bilderdatum = new ArrayList<String>();
	static List<String> endungen = new ArrayList<String>();
	static int d;
	static int a;
	static int e;
	static String basicPath;
	static String Ordnersys;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		/**
		 * Input des Pfades, in welchem die sich zu sortierenden Dateien befinden
		 * 
		 * @author Anton
		 */
		Scanner reader = new Scanner(System.in);
		System.out.println("Pfad der zu kopierenden Datein?");
		String pfad = reader.nextLine();

		/**
		 * Input des Pfades, in welchem die sortierten Dateien gespeichert werden sollen
		 * 
		 * @author Anton
		 */
		Scanner reader2 = new Scanner(System.in);
		System.out.println("BasisPfad in den kopiert werden soll?");
		basicPath = reader2.nextLine();
		
		/**
		 * Aufruf von Suche.java
		 * 
		 * @see Suche.java
		 * @author Anton
		 */
		Suche search = new Suche();
		search.listfiles(pfad);

		//Scanner reader2 = new Scanner(System.in);
		//System.out.println("BasisPfad in den kopiert werden soll?");
		//basicPath = reader2.nextLine();

		Scanner reader3 = new Scanner(System.in);
		System.out.println("Odnersystem 1.y/m/d/ oder 2. ymd/ ? type 1 or 2!");
		Ordnersys = reader3.nextLine();

		while (Integer.parseInt(Ordnersys) != 1
				&& Integer.parseInt(Ordnersys) != 2) {
			Scanner reader4 = new Scanner(System.in);
			System.out.println("Ungültige Angabe! 1 oder 2!");
			Ordnersys = reader4.nextLine();

		}

		search.mehrereDaten();
		e = search.getmehrereDatenint();

		for (int c = 0; c < e; c++) {
			Scanner reader5 = new Scanner(System.in);
			System.out.println("Dateityp?");
			String dattyp = reader5.next();
			endungen.add(dattyp);
		}

		for (int c = 0; c < e; c++) {

			a = c;
			search.setVariable(pfad);

			bilder = search.getBilder();
			d = search.getD();

			Sortierung sort = new Sortierung();
			sort.Sort();

			bilderdatum = sort.getBilderdatum();

			Kopieren copy = new Kopieren();
			copy.copy();
		}

		System.out.println("Erfolgreich kopiert...  glaube ich^^");

	}

	
	public List<String> getBilder() {
		return bilder;
	}

	public int getD() {
		return d;
	}

	public List<String> getBilderdatum() {
		return bilderdatum;
	}

	public String getbasicPath() {
		return basicPath;
	}

	public String getPfad() {
		return pfad;
	}

	public String getOrdnersys() {
		return Ordnersys;
	}

	public List<String> getendungen() {
		return endungen;
	}

	public int geta() {
		return a;
	}
}
