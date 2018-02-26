package TrabajarConString;
import edu.duke.*;
import org.apache.commons.csv.*;


public class PrimerCSVEjemplo {
	
	public static void leerComida(CSVParser parser) {
		
		for (CSVRecord record : parser) {
			System.out.print(record.get("Name") + " ");
			System.out.println(record.get("Favorite Food"));
		}
		
	}

	public static void ListaExportadores (CSVParser parser, String ExportacionInteres) {
		for (CSVRecord record : parser) {
			String export =record.get("Exports");
			if (export.contains(ExportacionInteres)){
				System.out.println(record.get("Country"));
			}
					
		}
		
	}
	
	public static void main(String[] args) {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		//leerComida(parser);
		ListaExportadores(parser,"coffee");

	}

}
