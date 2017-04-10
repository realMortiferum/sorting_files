import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Übernahme der Listen Bilder und Bilderdatum 
 * <p> 
 * Dateien in ein Ordnerverzeichnis(def durch ordnersys) kopieren
 * <p>
 * @author ala
 * @version 0.1
 */

public class Kopieren {

	List<String> bilder = new ArrayList<String>();
	List<String> bilderdatum = new ArrayList<String>();
	String basicPath;
	String finalPath;
	String year;
	String year2;
	String month;
	int monthinint;
	String monthString;
	String day;
	int dayint;
	String backsl;
	String bildname;
	String pfadlänge;
	String ordnersys;

	public void copy() throws IOException {

		Bildsortierung bildsort = new Bildsortierung();
		bilder = bildsort.getBilder();
		bilderdatum = bildsort.getBilderdatum();
		basicPath = bildsort.getbasicPath();
		backsl = "/";

		for (int c = 0; c < bilder.size(); c++) {

			int d = bildsort.getD();
			float df = d;
			float cf = c;
			float prozent = ((cf + 1) / df) * 100;
			System.out.println(new DecimalFormat("##.##").format(prozent) + " %");
			String s = bilderdatum.get(c);
			year = s.substring(0, Math.min(s.length(), 4));
			year2 = s.substring(2, 4);
			month = s.substring(5, 7);
			monthinint = Integer.parseInt(month);
			day = s.substring(8, 10);
			dayint = Integer.parseInt(day);

			switch (monthinint) {
			case 1:
				monthString = "1 - Januar";
				break;
			case 2:
				monthString = "2 - Februar";
				break;
			case 3:
				monthString = "3 - März";
				break;
			case 4:
				monthString = "4 - April";
				break;
			case 5:
				monthString = "5 - Mai";
				break;
			case 6:
				monthString = "6 - Juni";
				break;
			case 7:
				monthString = "7 - Juli";
				break;
			case 8:
				monthString = "8 - August";
				break;
			case 9:
				monthString = "9 - September";
				break;
			case 10:
				monthString = "10 - Oktober";
				break;
			case 11:
				monthString = "11 - November";
				break;
			case 12:
				monthString = "12 - Dezember";
				break;
			default:
				monthString = "ungültiger Monat";
				break;
			}

			ordnersys = bildsort.getOrdnersys();
			if (Integer.parseInt(ordnersys) == 1) {
				finalPath = basicPath + backsl + year + backsl + monthString
						+ backsl + dayint + backsl;
			} else {
				finalPath = basicPath + backsl + year2 + month + day + backsl;
			}

			File f = new File(bilder.get(c));

			Path copySourcePath = Paths.get(bilder.get(c));
			Path copyTargetPath = Paths.get(finalPath + f.getName());
			f = new File(finalPath + f.getName());
			f.mkdirs();
			Files.copy(copySourcePath, copyTargetPath,
					StandardCopyOption.REPLACE_EXISTING);
			System.out.println(f.getName() + " kopiert");

		}

	}

	public String getfinalPath() {
		return finalPath;
	}
}
