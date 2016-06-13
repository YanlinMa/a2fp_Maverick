public class Word {
  String word;
  String PoS;
  
  //default
  public Word(){
    word = "";
    PoS = "";
  }
  //word only
  public Word(String w){
    word = w;
    PoS = "";
  }
  //word and PoS
  public Word(String w, String p){
    word = w;
    PoS = p;
  }
  
  //accessor for word
  public String getWord(){
    return word;
  }
  //accessor for PoS
  public String getPoS(){
    return PoS;
  }
  
  //mutator for word
  public void setWord(String w){
    word = w;
  }
  //mutator for PoS
  public void setPoS(String p){
    PoS = p;
  }
    public String toString(){
	return word;
    }

}
