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
	
	public static void countryInfo (CSVParser parser, String Country) {
		boolean bandera = true;
		for (CSVRecord record : parser) {
			if (record.get("Country").equals(Country) && bandera){
				System.out.print(record.get("Country"));
				System.out.print(": ");
				System.out.print(record.get("Exports"));
				System.out.print(": ");
				System.out.println(record.get("Value (dollars)"));
				bandera=false;
				}
			}
			if (bandera)
				System.out.println("NOT FOUND");
					
		}
		
	public static void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2) {
		
		for (CSVRecord record : parser) {
			String exports =record.get("Exports");
			
			if (exports.contains(exportItem1) && exports.contains(exportItem2))
				System.out.println(record.get("Country"));
			}
					
		}
	
	public static void numberOfExporters (CSVParser parser, String exportItem) {
		int nroCountries = 0;
		for (CSVRecord record : parser) {
			String exports =record.get("Exports");
			if (exports.contains(exportItem))
				nroCountries++;
			}
			System.out.println(nroCountries);		
		}
	
	public static void bigExporters (CSVParser parser, String amount) {
		
			for (CSVRecord record : parser) {
				String value =record.get("Value (dollars)");
				if (value.length() > amount.length()) {
				System.out.print(record.get("Country"));
				System.out.print(" ");
				System.out.println(record.get("Value (dollars)"));
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		//leerComida(parser);
		//ListaExportadores(parser,"coffee");
		countryInfo(parser,"Nauru***");
		//listExportersTwoProducts (parser,"fish","nuts");
		//numberOfExporters(parser,"gold");
		//bigExporters(parser,"$999,999,999,999");
	}

}
