package TrabajarConString;
import edu.duke.*;
import org.apache.commons.csv.*;


public class PrimerCSVEjemplo {
	
	public static void leerComida() {
		FileResource fr = new FileResource("H:/Jhon/Documentos/Java-Android/foods.csv");
		CSVParser parser = fr.getCSVParser();
		for (CSVRecord record : parser) {
			System.out.print(record.get("Name") + " ");
			System.out.println(record.get("Favorite Food"));
		}
		
	}

	public static void main(String[] args) {

		leerComida();

	}

}
