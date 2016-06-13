//Choose a random text from Project Gutenberg
//Randomly generate a valid book number and input that into a string URL

import java.net.*;
import java.io.*;
import java.util.*;

public class Text {
    
    public static void main(String[] args) {
	
	//Store text stories
	ArrayList<String> stories = new ArrayList<String>();
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~
	Method one
        //Input file
        String file = "Stories.csv";
	System.out.println(file);
        BufferedReader fileReader = null;

	//Read file
        String delimiter = ",";
        String line = "";
        fileReader = new BufferedReader(new FileReader(file));
        while ((line = fileReader.readLine()) != null) {
        	String[] tokens = line.split(delimiter);
        	for (String token : tokens) {
        		stories.add(token);
        	}
        }
	fileReader.close();
	*/

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	Method two
	//Convert csv file into ArrayList
	File texts = new File("Stories.csv");
	System.out.println(texts);
	Scanner inputStream = new Scanner(texts);
	while(inputStream.hasNext()) {
		String data = inputStream.next();
		stories.add(data);
                System.out.println(data);
	}
	inputStream.close();
	*/
	
	//Random text out of the ArrayList
	int choose = (int)(Math.random()*43);
	String text = stories.get(choose);
	ArrayList<String> parse = new ArrayList<String>();
	int i = 0;
	while (i<text.length()) {
		if (text.substring(i,i+1).equals(" ")) {
			i++;
		}
		else if (Character.isLetter(text.substring(i,i+1))) {
			while 
		}
	}
	
    }

}
