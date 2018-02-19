package TrabajarConString;
import javax.swing.*;
 
 
public class encontrarCadena {
       
       public static int BuscarStopCodon (String adn, int startIndex, String stopCodon) {
             
             int actualIndex = adn.indexOf(stopCodon,startIndex+3);
             
             while (actualIndex > -1) {
                    if ((actualIndex-startIndex) % 3 ==0) {
                           return actualIndex ;
                    }
                    else
                           actualIndex = adn.indexOf(stopCodon,actualIndex+1);
             }
             return adn.length();
       }
       
       public static String EncontrarGen(String adn) {
             String resultado="";
             String adn1 = adn.toUpperCase();
             //Inicio Codom ATG
             int inicioCodon = adn1.indexOf("ATG");
             
             if (inicioCodon == -1) 
                    return "No hay GEN. No se encuentra ATG";
              //             
             //Fin Codom TTA, TGA y TAG
             int finCodonTAA = BuscarStopCodon(adn1,inicioCodon,"TAA");
             int finCodonTGA = BuscarStopCodon(adn1,inicioCodon,"TGA");
             int finCodoTAG= BuscarStopCodon(adn1,inicioCodon,"TAG");
             
             
             //resultado = adn.substring(startIndex, actualIndex+3);
             //return "El gen es: " + resultado;
             
             //return "No hay GEN. No se encuentra TAA";
             
             return "";
       }
       
       public static void main (String[] arg) {
       
             //String texto="ATGATCGCTAATAATTAAGCTGATAGG";
             String texto=JOptionPane.showInputDialog("Intoduce el codigo ADN");
             String gen="";
             /*int x = texto.length();
             String s = texto.substring(3, 7);
             int e = texto.indexOf("TTA");
             boolean sW = texto.startsWith("ATG");
             boolean eW = texto.endsWith("TTA");
             */
             //JOptionPane.showMessageDialog(null,x + "\n" + s + "\n" + e + "\n" + sW + "\n" + eW);
             
             gen=EncontrarGen(texto);
             System.out.println("La cadena introducida es : " + texto);
             System.out.println(gen);
             
             
       }
 
}
