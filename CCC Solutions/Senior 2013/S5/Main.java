/* Programming Competition - Template (Horatiu Lazu) */

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
	
	/* Credits to: http://mmhs.ca/ccc/2013/ccc2013s5fast.txt */
	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			int n = Integer.parseInt(in.readLine());
			int cost = 0;
			while(n > 1){
				int r = (int)(Math.sqrt(n))+1; //plus 1?
				int f = 2;
				while(f <= r && n % f != 0)
					f++;
					
				int x;
				if (f < n && n % f == 0){
					x = n/f;
					n = n - x;
					cost += n/x;
				}
				else{
					n--;
					cost += n;	
				}
			}
			System.out.println(cost);
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}