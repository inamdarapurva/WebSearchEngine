package project;


public class Alphabetize {
  private int sort_array[];
  private CircularShift cs;

  
  public int get_numOfLine(){
    return  cs.LineCounter();
  }

   public String select_line_string(int line){
    return cs.select_line_string(sort_array[line]);
  }

   
 public String[] fetch_Line(int line){
    return  cs.fetch_Line(sort_array[line]);
  }
 
 public void alphabetize(CircularShift shift){
    cs= shift;
    
   sort_array = new int[cs.LineCounter()];

   for(int i = 0; i < sort_array.length; i++)
      sort_array[i] = i;

    for(int i = (sort_array.length / 2 - 1); i >= 0; i--)
      downward_Shift(i, sort_array.length);

    for(int i = (sort_array.length - 1); i >= 1; i--){ 
      int temp = sort_array[0];
      sort_array[0] = sort_array[i];
      sort_array[i] = temp;
      downward_Shift(0, i);      
    }
  }


  private void downward_Shift(int root, int leaf){    
    int node_max = root * 2 + 1;

    while(node_max < leaf){
      if((node_max + 1) < leaf)
        if( cs.select_line_string(sort_array[node_max + 1]).compareTo(
           cs.select_line_string(sort_array[node_max])) > 0)
          node_max++;

      if( cs.select_line_string(sort_array[root]).compareTo( cs.select_line_string(sort_array[node_max])) < 0){
        int temp = sort_array[root];
        sort_array[root] = sort_array[node_max];
        sort_array[node_max] = temp;
        root = node_max;
        node_max = root * 2 + 1;
      }else
        break;
       
    }
  }
  
  
}
   

