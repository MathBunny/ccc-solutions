/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


class Main{
	public static void main (String [] args){
		new Main();
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			
			int goal = Integer.parseInt(in.readLine());
			int sum = 0;
			for(int i = 1; i <= goal - 3; i++){
				for(int x = i + 1; x <= goal - 2; x++){
					for(int y = x + 1; y <= goal - 1; y++){
						sum++;	
					}
				}	
			}
			System.out.println(sum);
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}