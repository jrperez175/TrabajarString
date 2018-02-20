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
             return -1;
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
             int finCodonTAG= BuscarStopCodon(adn1,inicioCodon,"TAG");
             
             //Selecciono el minimo valor
             
             //int temp  = Math.min(finCodonTAA, finCodonTGA);
             //int minfinCodon = Math.min(temp, finCodonTAG);
             
             int minfinCodon = 0;
             
             if (finCodonTAA == -1 || (finCodonTGA != -1 && finCodonTGA < finCodonTAA)){
            	 minfinCodon= finCodonTGA;
             }
             else {
            	 minfinCodon=finCodonTAA;
             }
             
             if (minfinCodon ==-1 || (finCodonTAG != -1 && finCodonTAG < minfinCodon)) {
            	 minfinCodon = finCodonTAG;
             }
             
             if (minfinCodon == -1) {
            	 return "No hay Gen";
             }
               
             return adn1.substring(inicioCodon, minfinCodon+3);
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
