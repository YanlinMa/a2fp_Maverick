import java.net.*;
import java.io.*;
import java.util.*;

//Driver file
public class MadLibber {
    private Identifier id;
    private ArrayList<Word> origWd;
    private ArrayList<Word> repWd;
    private final static String PUNCNO = " !@#$%^&*()_=+`~[]\\{}|;':\",./<>?1234567890";

    public MadLibber (){
	id = new Identifier();
	origWd = new ArrayList<Word>();
	repWd = new ArrayList<Word>();
    }
    
    //takes in a Word from the downloaded text
    //prompts user to give a word to replace it with
    public Word replace(Word orig){
	System.out.print("Please supply us with a "+orig.getPoS()+":");
	String userWd = Keyboard.readString();
	String l = userWd.toLowerCase();
	for (int i = 0; i < l.length();i++) {
	    if (!((int)l.charAt(i) >= 97 && (int)l.charAt(i) <= 122)) {
		System.out.println("Error: You did not input letters only. Word will be skipped.");
		return orig;
	    }
	}
	Word nwWrd = id.categorizer(userWd);
	return nwWrd;
    }
    
    public void run(){
	System.out.println("MadLib");
	System.out.println("By Team Maverick");
	System.out.println(" 1. Begin \n 2. End");
	System.out.print("Your choice: ");
	String ready = Keyboard.readString();
	if (ready.equals("1")) {
	    Text b = new Text();
	    ArrayList<String> text = b.parse();
	    //categorizes the words
	    for (int i = 0; i<text.size();i++){
		//non-letters?
		String l = text.get(i).toLowerCase();
		boolean notWd = false;
		for (int p = 0; p < l.length();p++) {
		    if (!((int)l.charAt(p) <= 97 && (int)l.charAt(p) >= 122)) {
			notWd = true;
		    }
		}
		if (notWd) origWd.add(new Word(text.get(i),"not"));
		else {
		    //all letters
		    Word y = id.categorizer(text.get(i));
		    origWd.add(y);
		}
	    }
	    //replacer
	    for (int i = 0;i<origWd.size();i++){
		//check if not a word
		if (origWd.get(i).getPoS().equals("not")){
		    repWd.add(origWd.get(i));
		}
		//check if noun
		else if (origWd.get(i).getPoS().equals("PluNoun") ||
			 origWd.get(i).getPoS().equals("SinNoun")){
		    //if noun used before
		    if (origWd.indexOf(origWd.get(i).getPoS()) < i ||
			origWd.indexOf(origWd.get(i).getPoS()) < i){
			//used before, then take the noun replaced
			repWd.add(repWd.get(origWd.indexOf(origWd.get(i))));
		    }
		    else {
			repWd.add(replace(origWd.get(i)));
		    }
		}
		else if (origWd.get(i).getPoS().equals("Other")){
		    repWd.add(origWd.get(i));
		}
		else {//not a noun/noun used before
		    repWd.add(replace(origWd.get(i)));
		}
	    }
	}
	else return; //end
    }
	    

    public String toString(){
	String ret="";
	for (int i=0;i<repWd.size();i++){
	    ret+=repWd.get(i);
	}
	return ret;
    }

    public static void main (String[]args){
	MadLibber excerpt = new MadLibber();
	excerpt.run();
	System.out.println(excerpt);
    }
}
