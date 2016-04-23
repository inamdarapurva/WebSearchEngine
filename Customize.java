package project;

/**
 *
 * @author APURVA
 */
import java.util.ArrayList;

public class Customize {
  
	private ArrayList<String> setup_word= new ArrayList<String>();

	
	
	public void add(String word) {
		setup_word.add(word);
	}

	public void remove(int index) {
	setup_word.remove(index);
	}
        public String get(int index) {
	return setup_word.get(index);
	}
        public void set(int index, String word) {
	setup_word.set(index, word);
	}

        public int size() {
	return setup_word.size();
	}

	public void clear() {
		setup_word.clear();
	}
}
  

