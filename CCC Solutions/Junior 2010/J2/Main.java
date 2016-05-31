/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


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
			int a = Integer.parseInt(in.readLine());
			int b = Integer.parseInt(in.readLine());
			int c = Integer.parseInt(in.readLine());
			int d = Integer.parseint(in.readLine());
			int s = Integer.parseInt(in.readLine());
			
			int personA = 0;
			int personB = 0;
			
			int currentA = 0;
			boolean justForward = false; 
			int currentB = 0;
			
			
			for(int i = 0; i < s; i++){
				if (currentA == 0){
						
				}
			}
			
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}