package project;


/**
 *
 * @author APURVA */

public class CircularShift {
 

private LineStorage ls= new LineStorage();

		

	public void performShift(String s) {
		String[] str = s.split(" ");
		for (int i = 0; i < str.length; i++) {
			ls.blank_line();
			for (int j = i; j < (str.length + i); j++)
				ls.word_add(str[j % str.length],
						ls.lineCount() - 1);
		}
	}

	
	public char getCharacter(int pos, int word, int line) {
		return ls.fetch_Character(pos, word, line);
	}

	
	public int CharacterCount(int word, int line) {
		return ls.Character_count(word, line);
	}
        
        public void set_input(LineStorage l) {
		ls = new LineStorage();

		for (int i = 0; i < l.lineCount(); i++) {
			String[] str = l.fetch_Line(i);
			for (int j = 0; j < str.length; j++) {
				ls.blank_line();
				for (int k = j; k < (str.length + j); k++)
				ls.word_add(str[k % str.length], 
                                        ls.lineCount()- 1);
			}
		}
	}

		public String getWord(int word, int line) {
		return ls.fetch_word(word, line);
        }

	

	public int WordCount(int line) {
		return ls.wordcount(line);
	}

	
	public String[] fetch_Line(int line) {
		return ls.fetch_Line(line);
	}

	
	public String select_line_string(int line) {
		return ls.select_line_string(line);
        }

	
	public int LineCounter() {
		return ls.lineCount();
	}
        
        public void line_setup(String words[],int index)
        {
            ls.line_setup(words,index);
        }

	  
}
