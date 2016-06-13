//Driver file
public class MadLibber {
    private Identifier id;
    private ArrayList<Word> origWd;
    private ArrayList<Word> repWd;
    private final static String PUNC = "!@#$%^&*()_=+`~[]\\{}|;':\",./<>?";

    public MadLibber (){
	id = new Identifier();
	origWd = new ArrayList<Word>();
	repWd = new ArrayList<Word>();
    }
    
    //takes in a Word from the downloaded text
    //prompts user to give a word to replace it with
    public Word replace(Word orig){
	System.out.print("Please supply us with a "+orig.getPos()+":");
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
	    Text text = new Text();
	    //categorizes the words
	    for (int i = 0; i<text.size();i++){
		for (int a = 0; a<PUNC.length();a++){
		    if (text.get(i).indexOf(PUNC.substring(a,a+1)) == -1){
			origWd.add(id.categorizer(text[i]));
			//replaces
			//check if noun
			if (origWd.get(i).getPos().equals("PluNoun") ||
			    origWd.get(i).getPos().equals("SinNoun")){
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
			words.add(text[i],"not");
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
	for (int i=0,i<repWd.size();i++){
	    ret+=i.get(i);
	}
	return ret;
    }

    public static void main (String[]args){
	MadLibber excerpt = new MadLibber();
	excerpt.run();
	System.out.println(excerpt);
    }
}
