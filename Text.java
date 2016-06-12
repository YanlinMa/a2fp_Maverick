//Choose a random text from Project Gutenberg
//Randomly generate a valid book number and input that into a string URL

import java.net.*;
import java.io.*;
import java.util.*;

public class Text {
    
    public static void main(String[] args) {
	
	//Array for text stories
	ArrayList<String> stories = new ArrayList<String>();
	
	//Convert csv file into ArrayList
	File texts = new File("Stories.csv");
	System.out.println(texts);
	/*Scanner inputStream = new Scanner(texts);
	while(inputStream.hasNext()) {
		String data = inputStream.next();
		stories.add(data);
                System.out.println(data);
	}
	inputStream.close();
	*/
    }

}
