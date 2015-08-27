/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


class Main{
	
	public static class Lights{
		int light1;
	}
	
	public static void main (String [] args){
		new Main();
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			
			//PrintWriter out = new PrintWriter(new FileWriter(""));
			int lights = Integer.parseInt(in.readLine());
			int [] state = new int[lights];
			for(int i = 0; i < lights; i++)
				state[i] = Integer.parseInt(in.readLine());
			
			if (lights == 4){
				int [] [] [] [] dp = new int[2][2][2][2];
					
			}
			int moves = 0;
			
			
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}