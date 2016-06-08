//Choose a random text from Project Gutenberg
//Randomly generate a valid book number and input that into a string URL

import java.net.*;
import java.io.*;

public class Text {

  //Randomly select a book serial number
  //Does every serial number lead to a valid book?
  int serial = Math.random() * (52771 - 1) + 1;

  String url = "http://www.gutenberg.org/files/" + serial + "/" + serial + "-0.txt";
  
  URL gutenberg = new URL(url);
  BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
  
  String input = in.readLine();
  while (input != null)
    System.out.println(input);
  in.close();
  
  //Check for string "Language: English" to make sure it's English

}
