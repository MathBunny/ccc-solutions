/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


class Main{
	int [] pies;
	int [] spare;
	public static void main (String [] args){
		new Main();
	}
	
	public int solve(int position, boolean take, int left, int right){
			
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//Load data
			int N = Integer.parseInt(in.readLine());
			pies = new int[N];
			for(int i = 0; i < N; i++)
				pies[i] = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			spare = new int[M];
			for(int i = 0; i < M; i++)
				spare[i] = Integer.parseInt(in.readLine());
			
			
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}