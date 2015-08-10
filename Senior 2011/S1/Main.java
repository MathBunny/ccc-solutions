/*
Programming competition file template
Made by Horatiu Lazu
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;



public class Main{
	public static void main (String [] args){
		new Main();
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			
			//PrintWriter out = new PrintWriter(new FileWriter(""));
			int inputs = Integer.parseInt(in.readLine());
			int tCounter = 0;
			int sCounter = 0;
			
			for(int i = 0; i < inputs; i++){
				String input = in.readLine();
				for(int x =0; x < input.length(); x++){
					if (input.charAt(x) == 't' || input.charAt(x) == 'T')
						tCounter++;
					else
					   if (input.charAt(x) == 'S' || input.charAt(x) == 's')
							sCounter++;
				}
			}	
			System.out.println((tCounter > sCounter) ? ("English") : ("French"));					
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}