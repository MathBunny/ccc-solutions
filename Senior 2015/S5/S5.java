/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


class Main{
	public static void main (String [] args){
		new Main();
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			int pies = Integer.parseInt(in.readLine());
			int [] piesSugar = new int[pies];
			for(int i = 0; i < pies; i++)
				pies[i] = Integer.parseInt(in.readLine());
			int sparePies = Integer.parseInt(in.readLine());
			int [] spareSugar = new int[sparePies];
			for(int i = 0; i < sparePies; i++)
				sparePies[i] = Integer.parseInt(in.readLine());
			
			int currentIndex = 0;
			Arrays.sort(sparePies);
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}