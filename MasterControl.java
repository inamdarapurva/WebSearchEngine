package project;

/**
 *
 * @author APURVA
 */
import java.util.Scanner;
import javax.swing.*;
import project.mydata;


public class MasterControl  {
    Scanner s=new Scanner(System.in);
    public void start(String s) {
		CircularShift shifter = new CircularShift();
		Input input = new Input(shifter);
		Alphabetize alphabetizer = new Alphabetize();
                //mydata data= new mydata();
                //input.takeInput();
                String line = s.trim();
                shifter.performShift(line);
                alphabetizer.alphabetize(shifter);
		for (int i = 0; i < alphabetizer.get_numOfLine(); i++)
                {
                    System.out.println((alphabetizer.select_line_string(i)));
                    //Area2.append(alphabetizer.select_line_string(i)+"\n");
                }
                
                
		
		
                      /* System.out.println("-------------------User Menu--------------------");
                       System.out.println("\n1.Enter Input\n2.Display Output\n3.Exit");
                       while (true) {
                       System.out.print("Enter your choice::");
			 int choice=s.nextInt();
			
			switch (choice) {
			case 1://Entering Input
				System.out.print("Enter Input::");
				input.takeInput();
				break;
                            
			case 2://displaying output
				alphabetizer.alphabetize(shifter);
				for (int i = 0; i < alphabetizer.get_numOfLine(); i++)
                                System.out.println(alphabetizer.select_line_string(i));
				break;
                            
			case 3: //Exit
				return;
			default:
				break;
			}
		}*/
                       
                       
   /**public static void start(JTextArea a,JTextArea b,JTextArea c)
    {
        String[] lines=a.getText().toString().split("@");
        System.out.println(lines[0]);
//        System.out.println(lines[1]);
        input.addLines(lines);
        System.out.println("Size of ls"+input.getLines().size());
       // cs.getCircularShiftedLines(input.getLines());
        System.out.println(input.getLines().size());
        List<String> CSlines=new ArrayList<>();
        CSlines=cs.getCircularShiftedLines(input.getLines());
        output.onputCSLines(CSlines,c);
        output.onputLines(ai.getAlphaShiftedLines(CSlines),b);*/
    }


	
	
	/*public static void main(String[] args) {
		MasterControl mc ;
                mc= new MasterControl();
		mc.start();
	}*/
}