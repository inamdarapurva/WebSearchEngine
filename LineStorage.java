package project;


/**
 *
 * @author APURVA
 */

 import java.util.ArrayList;


public class LineStorage {

          private ArrayList<Customize> custom_line = new ArrayList<Customize>();

	
             
        public String fetch_word(int word, int line) {
		return custom_line.get(line).get(word);
	}
                
                
         public int Character_count(int word, int line) {
		return custom_line.get(line).get(word).length();
	}
        
         public int lineCount() {
            return custom_line.size();
	}

	
        public int wordcount(int line) {
		return custom_line.get(line).size();
	}
        
        public void line_setup(String word[], int line) {
		Customize recentline = custom_line.get(line);
		recentline.clear();
             for (String word1 : word) {
                 recentline.add(word1);
             }
	}

        
        public void word_add(String chars, int line) {
	Customize recentline = custom_line.get(line);
	recentline.add(chars);
	}

	     

        public void blank_line() {
	
            Customize recentline = new Customize();
        
            custom_line.add(recentline);
	}  
          
      

	public String select_line_string(int line) {
	Customize recentline = custom_line.get(line);
	int size = recentline.size();

	int len = 0;
	for (int x = 0; x < size; x++)
	len = len+ fetch_word(x, line).length();
	len =len+ (size - 1);

	char temp[] = new char[len];
	int count = 0;
	for (int x = 0; x < size; x++) {
	fetch_word(x, line).getChars(0, fetch_word(x, line).length(), temp, count);
	count += fetch_word(x, line).length();
	if (x != (size - 1))
	temp[count++] = ' ';
	}

	return new String(temp);
	}

	public char fetch_Character(int pos, int word, int line) {
		return custom_line.get(line).get(word).charAt(pos);
	}
        public String[] fetch_Line(int line) {
		Customize recentline = custom_line.get(line);
		String[] temp = new String[recentline.size()];
		for (int x = 0; x < temp.length; x++)
			temp[x] = (String) recentline.get(x);
		return temp;
	        }
	
	}
