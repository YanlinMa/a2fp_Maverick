//Driver file
public class MadLibber {
    Identifier id;
    
    public MadLibber (){
	id = new Identifier();
    }
    
    //takes in a Word from the downloaded text
    //prompts user to give a word to replace it with
    public Word replace(Word orig){
	System.out.print("Please supply us with a "+orig.getPos()+":");
	String userWd = Keyboard.readString();
	Word nwWrd = id.categorizer(userWd);
	return nwWrd;
    }
    
    public static void main (String[]args){
	
	//Text text = new Text();
    }
}
