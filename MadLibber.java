import java.net.*;
import java.io.*;
import java.util.*;

//Driver file
public class MadLibber {
    private Identifier id;
    private ArrayList<Word> origWd;
    private ArrayList<Word> repWd;
    private final static String PUNC = " !@#$%^&*()_=+`~[]\\{}|;':\",./<>?";

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
		for (int a = 0; a<PUNC.length();a++){
		    if (text.get(i).indexOf(PUNC.substring(a,a+1)) == -1){
			origWd.add(id.categorizer(text.get(i)));
			//replaces
			//check if noun
			if (origWd.get(i).getPoS().equals("PluNoun") ||
			    origWd.get(i).getPoS().equals("SinNoun")){
			    repWd.add(replace(origWd.get(i)));
			}
			//if noun used before
			else if (origWd.indexOf(origWd.get(i).getPoS()) < i ||
			    origWd.indexOf(origWd.get(i).getPoS()) < i){
			    //used before, then take the noun replaced
			    repWd.add(repWd.get(origWd.indexOf(origWd.get(i))));
			}
			else {//not a noun/noun used before
			    repWd.add(replace(origWd.get(i)));
			}
		    }
		    else { //if not a word
			Word not = new Word(text.get(i),"not");
			origWd.add(not);
		    }
		}
	    }
	}
	else {
	    return;
	}
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
