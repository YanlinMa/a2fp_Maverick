import java.io.*;
import java.util.*;

//Identifies Unknown Type of Words and Verifies Identified Words
//Need to add comments

public class Identifier{
	
	private ArrayList<String> ProNoun = new ArrayList<String>();
	private ArrayList<String> PluNoun = new ArrayList<String>();
	private ArrayList<String> SinNoun = new ArrayList<String>();
	private ArrayList<String> Adj = new ArrayList<String>();
	private ArrayList<String> Advb = new ArrayList<String>();
	private ArrayList<String> FutVerb = new ArrayList<String>();
	private ArrayList<String> PstVerb = new ArrayList<String>();
	private ArrayList<String> PreVerb = new ArrayList<String>();
	private ArrayList<String> Other = new ArrayList<String>();

	public Identifier(){
		try {
			Scanner inputStream = new Scanner(new File("ProNoun.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				ProNoun.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
		
		try {
			Scanner inputStream = new Scanner(new File("PluNoun.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				PluNoun.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
		
		try {
			Scanner inputStream = new Scanner(new File("SinNoun.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				SinNoun.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
		
		try {
			Scanner inputStream = new Scanner(new File("Adj.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				Adj.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
		
		try {
			Scanner inputStream = new Scanner(new File("Advb.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				Advb.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
		
		try {
			Scanner inputStream = new Scanner(new File("FutVerb.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				FutVerb.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
		
		try {
			Scanner inputStream = new Scanner(new File("PstVerb.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				PstVerb.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
		
		try {
			Scanner inputStream = new Scanner(new File("PreVerb.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				PreVerb.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
		
		try {
			Scanner inputStream = new Scanner(new File("Other.txt"));
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				Other.add(data);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
	        	e.printStackTrace();
		}
	}

	public Word categorizer(String s){
		Word ret;
		String l = s.toLowerCase();
		char test = l.charAt(0);
		for (int i = 0; i < l.length();i++) {
		    if (!(Character.isLetter(l.charAt(i)))){
			return new Word(s,"not");
		    }
                }
		if (ProNoun.contains(cs)) {
			ret = new Word(s, "ProNoun");
			return ret;
		}
		else if (PluNoun.contains(l)) {
			ret = new Word(s, "PluNoun");
			return ret;
		}
		else if (SinNoun.contains(l)) {
			ret = new Word(s, "SinNoun");
			return ret;
		}
		else if (Adj.contains(l)) {
			ret = new Word(s, "Adj");
			return ret;
		}
		else if (Advb.contains(l)) {
			ret = new Word(s, "Advb");
			return ret;
		}
		else if (FutVerb.contains(l)) {
			ret = new Word(s, "FutVerb");
			return ret;
		}
		else if (PstVerb.contains(l)) {
			ret = new Word(s, "PstVerb");
			return ret;
		}
		else if (PreVerb.contains(l)) {
			ret = new Word(s, "PreVerb");
			return ret;
		}
		else if (Other.contains(l)) {
			ret = new Word(s, "Other");
			return ret;
		}
		else {
			System.out.println("Please identify this word: \n For proper nouns type: ProNoun \n For plural nouns type: PluNoun \n For singular nouns type: SinNoun \n For adjectives type: Adj \n For adverb type: Advb \n For future verbs type: FutVerb \n For past verbs type: PstVerb \n For present verbs type: PreVerb \n For other type: Other  \n" );
			String response = Keyboard.readString();
			if (response.equals("ProNoun")) {
				ProNoun.add(l);
			}
			else if (response.equals("PluNoun")) {
				PluNoun.add(l);
			}
			else if (response.equals("SinNoun")) {
				SinNoun.add(l);
			}
			else if (response.equals("Adj")) {
				Adj.add(l);
			}
			else if (response.equals("Advb")) {
				Advb.add(l);
			}
			else if (response.equals("PstVerb")) {
				PstVerb.add(l);
			}
			else if (response.equals("FutVerb")) {
				FutVerb.add(l);
			}
			else if (response.equals("PreVerb")) {
				PreVerb.add(l);
			}
			else if (response.equals("Other")){
				Other.add(l);
			}
			else {
				return categorizer(s);
			}
			try {			
				String file = response + ".txt";
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(",\"" + l + "\"");
				writer.close();
				ret = new Word(s, response);
				return ret;
			}
			catch (IOException e){
			e.printStackTrace();
			return new Word(s,"Other");
			}
		}	
	}

	public Boolean analyzer(String s, String cat) {
		String l = s.toLowerCase();
		for (int i = 0; i < l.length();i++) {
		    if (!(Character.isLetter(l.charAt(i)))){
			System.out.println("This is gibberish, try again.");
			return false;
		    }
		}
		if (cat.equals("ProNoun")) {
			return ProNoun.contains(l);
		}
		else if (cat.equals("PluNoun")) {
			return PluNoun.contains(l);
		}
		else if (cat.equals("SinNoun")) {
			return SinNoun.contains(l);
		}
		else if (cat.equals("Adj")) {
			return Adj.contains(l);
		}
		else if (cat.equals("Advb")) {
			return Advb.contains(l);
			}
		else if (cat.equals("PstVerb")) {
			return PstVerb.contains(l);
		}
		else if (cat.equals("FutVerb")) {
			return FutVerb.contains(l);
		}
		else if (cat.equals("PreVerb")) {
			return PreVerb.contains(l);
		}
		else if (cat.equals("Other")){
			return Other.contains(l);
		}
		else {
			System.out.println("Are you sure this word is in the correct category? (y or n):");
			String response = Keyboard.readString();
			if (response.equals("y")) {
				if (cat.equals("ProNoun")) {
					ProNoun.add(l);
				}
				else if (cat.equals("PluNoun")) {
					PluNoun.add(l);
				}
				else if (cat.equals("SinNoun")) {
					SinNoun.add(l);
				}
				else if (cat.equals("Adj")) {
					Adj.add(l);
				}
				else if (cat.equals("Advb")) {
					Advb.add(l);
				}
				else if (cat.equals("PstVerb")) {
					PstVerb.add(l);
				}
				else if (cat.equals("FutVerb")) {
					FutVerb.add(l);
				}
				else if (cat.equals("PreVerb")) {
					PreVerb.add(l);
				}
				else{
					Other.add(l);
				}
				try {			
					String file = response + ".txt";
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));
					writer.write(",\"" + l + "\"");
					writer.close();
				}
				catch (IOException e){
					e.printStackTrace();
				}
				return true;
			}
			else if (response.equals("n")) {
				System.out.println("Thank you for your response!");
				return false;
			}
			else {
				return analyzer(s, cat);
			}
		}
	}
		
	public void initialize(List<String> a, String file) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String s = "";
		try {
        		
        		String line = reader.readLine();

        		while (line != null) {
            			s += line;
			        line = reader.readLine();
        		}
		a = Arrays.asList(s.substring(1,s.length()- 1).split("\".\""));
        	}
		finally {
			reader.close();
		}
		
	}

    public static void main (String[]args){
	Identifier id = new Identifier();
	id.categorizer("The");
    }

}
