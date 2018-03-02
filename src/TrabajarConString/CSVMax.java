package TrabajarConString;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {

	public static CSVRecord maximaTemperatura(CSVParser parser) {

		CSVRecord Maxtemperatura = null;

		for (CSVRecord actualFila : parser) {

			if (Maxtemperatura == null) {
				Maxtemperatura = actualFila;
			} else {
				double actualTemperatura = Double.parseDouble(actualFila.get("TemperatureF"));
				double maximaTEmperatura = Double.parseDouble(Maxtemperatura.get("TemperatureF"));
				if (actualTemperatura > maximaTEmperatura) {
					Maxtemperatura = actualFila;
				}
			}
		}
		return Maxtemperatura;
	}
	
	public static CSVRecord maximaTemperaturaVariosDias() {
		CSVRecord maximaTemperatura = null;
		DirectoryResource dr = new DirectoryResource();
		
		for (File f : dr.selectedFiles()) {
			
			FileResource fr = new FileResource(f);
			CSVRecord actualFila = maximaTemperatura(fr.getCSVParser());
			
			if (maximaTemperatura==null) {
				maximaTemperatura= actualFila;
			}
			else {
				double actualTemperatura = Double.parseDouble(actualFila.get("TemperatureF"));
				double maximaTEmperatura = Double.parseDouble(maximaTemperatura.get("TemperatureF"));
				if (actualTemperatura > maximaTEmperatura) {
					maximaTemperatura = actualFila;
				}
			}
		}
		return	maximaTemperatura;
	}

	public static void main(String[] args) {
		//FileResource fr = new FileResource("D:/Users/jrperez/Documents/Jhon/eclipse/Ejemplos/nc_weather/2012/weather-2012-09-05.csv");
		CSVRecord parser = maximaTemperaturaVariosDias();
		System.out.println("La temperatura mas alta fue : " + parser.get("TemperatureF") + " a las " + parser.get("TimeEDT") + " del " + parser.get("DateUTC"));

	}

}
