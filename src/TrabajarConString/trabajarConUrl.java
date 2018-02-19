import javax.swing.*;
import edu.duke.*;
import java.io.*;



public class trabajarConUrl {
    public static void findLinks() {
        URLResource webPage = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html"); 
		for ( String word : webPage.words() ) {
		    String wLow = word.toLowerCase();
			if ( wLow.contains( "youtube.com" ) && ( wLow.contains("https://") || wLow.contains("http://"))) {
			    int startQuote = wLow.indexOf("\"");
			    int endQuote = wLow.lastIndexOf("\"");
			    String ytLink = word.substring( startQuote+1, endQuote );
			    System.out.println( ytLink );
            }
		}
    }
    public static void main (String[] arg) {
    	findLinks();
    }
}