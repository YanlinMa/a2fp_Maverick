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
	try {
	    URL gutenberg = new URL("http://www.gutenberg.org/ebooks/52770/");
	} 
	catch (MalformedURLException e) {
	    // exception handler code here
	    // ...
	}
	BufferedReader in = new BufferedReader(new InputStreamReader(gutenberg.openStream()));
	
	/*String input;
	while ((input = in.readLine()) != null)
	    System.out.println(input);
	in.close();
	*/
	//Check for string "Language: English" to make sure it's English

    }

}
