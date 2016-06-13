//Choose a random text from Stories.csv
//Parse the text, separating it into an ArrayList

import java.net.*;
import java.io.*;
import java.util.*;

public class Text {
    
    public static void main(String[] args) {
	
	//Store text stories
	ArrayList<String> stories = new ArrayList<String>();

	//Read csv file
	try {
		Scanner inputStream = new Scanner(new File("Stories.csv"));
		while(inputStream.hasNext()) {
			String data = inputStream.nextLine();
			stories.add(data);
		}
	inputStream.close();
	}
	catch (FileNotFoundException e) {
        	e.printStackTrace();
	}
	
	//Random text out of the ArrayList
	int choose = (int)(Math.random()*43);
	String text = stories.get(choose);
	System.out.println(text);
	/*ArrayList<String> parse = new ArrayList<String>();
	int i = 0;
	while (i<text.length()) {
		if (text.substring(i,i+1).equals(" ")) {
			i++;
		}
		else if (Character.isLetter(text.substring(i,i+1))) {
			while 
		}
	}*/
	
    }

}
