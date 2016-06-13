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
	//Convert to ArrayList
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
	
	//Parse the chosen text
	ArrayList<String> parsed = new ArrayList<String>();
	int i = 1;
	while (i<text.length()-1) {
		String part;
		//Possessive "s" needs to be split
		if (text.substring(i,i+3).equals("'s ")) {
			part = text.substring(i,i+3);
			i += 3;
		}
		//Split by words
		else if (Character.isLetter((char)text.substring(i,i+1))) {
			int beg = i;
			i++;
			while (Character.isLetter(text.substring(i,i+1))||text.substring(i,i+1).equals("-")||text.substring(i,i+1).equals("'")) {
				i++;
			}
			part = text.substring(beg,i);
		}
		//Split by punctuation and spaces
		else if (!Character.isLetter(text.substring(i,i+1))) {
			int beg = i;
			i++;
			while (!Character.isLetter(text.substring(i,i+1))) {
				i++;
			}
			part = text.substring(beg,i);
		}
		parsed.add(part);
	}
	//return parsed;
    }
}
