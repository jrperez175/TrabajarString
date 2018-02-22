package TrabajarConString;
import javax.swing.*;
import edu.duke.*;
 
 
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
       
       public static String EncontrarGen(String adn, int inicio) {
             String resultado="";
             String adn1 = adn.toUpperCase();
             //Inicio Codom ATG
             int inicioCodon = adn1.indexOf("ATG",inicio);
             
             if (inicioCodon == -1) 
                    return "";
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
            	 return "";
             }
               
             return adn1.substring(inicioCodon, minfinCodon+3);
       }
       
       
       public static StorageResource almacenarTodosGenes (String adn) {
    	   
    	   StorageResource listaGenes = new StorageResource();
    	   int inicioIndece = 0;
    	   
    	   
    	   while (true) {
    		   String actualGen = EncontrarGen(adn,inicioIndece);
    		   if (actualGen.isEmpty()) {
    			   break;
    		   }
    		   listaGenes.add(actualGen);
    		   inicioIndece = adn.indexOf(actualGen,inicioIndece) + actualGen.length();
    	   }
    	   return listaGenes;
       }
       
       public static void main (String[] arg) {
       
             //String texto="ATGATCTAATTTATGCTGCAACGGTGAAGAATGTAG";
             String texto=JOptionPane.showInputDialog("Intoduce el codigo ADN");
             String gen="";
             
             /*int x = texto.length();
             String s = texto.substring(3, 7);
             int e = texto.indexOf("TTA");
             boolean sW = texto.startsWith("ATG");
             boolean eW = texto.endsWith("TTA");
             */
             //JOptionPane.showMessageDialog(null,x + "\n" + s + "\n" + e + "\n" + sW + "\n" + eW);
             
             System.out.println("La cadena introducida es : " + texto);
             System.out.println("Los genes son");
             StorageResource genes = almacenarTodosGenes(texto);
             
             for (String g: genes.data() ) {
            	 System.out.println(g);
             }
             
             //System.out.println(gen);
             
             
       }
 
}
