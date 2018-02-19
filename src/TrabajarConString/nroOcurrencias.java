package TrabajarConString;
import javax.swing.*;

public class nroOcurrencias {
	public static boolean dosOcurrencias(String patron,String texto) {
		
		int i=0;
		int contador=0;
		while (i>=0) {
			i= texto.indexOf(patron,i);
			if (i >-1) {
				i=i+patron.length();
				contador++;
			}
		}
		System.out.println("Contador: " + contador);
		
		if (contador > 1)
			return true;
		else
			return false;
	}
	
	public static String ultimaParte(String patron,String texto) {
		String ultParte="";
		
		if (texto.indexOf(patron)>-1)
			ultParte= texto.substring(texto.indexOf(patron)+patron.length(), texto.length());
		else
			ultParte= texto;
		return ultParte;
	}
	
	public static void main (String[] arg) {
		boolean ocurrencia;
		String texto = JOptionPane.showInputDialog("Ingrese la Cadena de texto");
		String patron = JOptionPane.showInputDialog("Ingrese el patron a buscar");
		
		ocurrencia=dosOcurrencias(patron,texto);
		String ultParte=ultimaParte(patron,texto);
		System.out.println("En el texto: " + texto);
		System.out.println("Se encuentra el patron : " + patron + " , mas de una vez? " + ocurrencia);
		System.out.println("La ultima parte es : " + ultParte);
	}
}
