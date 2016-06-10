//Choose a random text from Project Gutenberg
//Randomly generate a valid book number and input that into a string URL

import java.net.*;
import java.io.*;
import java.util.*;

public class Text {
    
    public static void main(String[] args) {
	
	//Randomly select a book serial number
	//Does every serial number lead to a valid book?
	int serial = (int)(Math.random() * (52771 - 1) + 1);
	
	String url = "http://www.gutenberg.org/files/" + serial + "/" + serial + "-0.txt";
	
	URL gutenberg = null;

	try {
	    gutenberg = new URL("http://www.gutenberg.org/files/52296/52296-h/52296-h.htm");
	} 
	catch (MalformedURLException e) {
	    // exception handler code here
	    // ...
	}
	
	try {
	    if ( gutenberg != null ) {
		BufferedReader in = new BufferedReader(new InputStreamReader(gutenberg.openStream()));
	    }
	}
	catch (IOException e) { // catch all IOExceptions not handled by previous catch blocks
	    System.out.println("General I/O exception: " + e.getMessage());
	    e.printStackTrace();
	} 
	
	/*String input;
	while ((input = in.readLine()) != null)
	    System.out.println(input);
	in.close();
	*/
	//Check for string "Language: English" to make sure it's English

    }

}
