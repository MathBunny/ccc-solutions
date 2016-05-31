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
	
	static class Glass {
		int minX;
		int minY;
		int maxX;
		int maxY;
		public Glass(int minX, int minY, int maxX, int maxY){
			this.minX = minX;
			this.minY = minY;
			this.maxX = maxX;
			this.maxY = maxY;	
		}
		
		
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			int piecesOfGlass = Integer.parseInt(in.readLine());
			int tintThreashold = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}