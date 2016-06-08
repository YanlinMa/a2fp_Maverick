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
  
  String input;
  while ((input = in.readLine()) != null)
    System.out.println(input);
  in.close();
  
  //Check for string "Language: English" to make sure it's English


        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();

        String str;
        while ((str = in.readLine()) != null) {
            str = in.readLine().toString();
            System.out.println(str);
            // str is one line of text; readLine() strips the newline character(s)
        }
        in.close();


}
