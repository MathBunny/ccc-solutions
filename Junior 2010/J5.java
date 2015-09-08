/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


class Main{
	int [] [] dp = new int[8][8];
	
	public static void main (String [] args){
		new Main();
	}
	
	public int recurse(int moves, int x, int y, int dX, int dY){
		if (x < 0 || x >= 8 || y < 0 || y >= 8)
			return Integer.MAX_VALUE;
		if (x == dX && y == dY)
			return moves;
		if (dp[x][y] < moves)
			return Integer.MAX_VALUE;
		dp[x][y] = moves;
		int [] possibilities = new int[8];
		possibilities[0] = recurse(moves+1, x -2, y + 1, dX, dY); 
		possibilities[1] = recurse(moves+1, x -2, y - 1, dX, dY); 
		possibilities[2] = recurse(moves+1, x -1, y + 2, dX, dY); 
		possibilities[3] = recurse(moves+1, x -1, y - 2, dX, dY); 
		possibilities[4] = recurse(moves+1, x + 1, y + 2, dX, dY); 
		possibilities[5] = recurse(moves+1, x + 1, y - 2, dX, dY); 
		possibilities[6] = recurse(moves+1, x +2, y + 1, dX, dY); 
		possibilities[7] = recurse(moves+1, x +2, y - 1, dX, dY); 
		Arrays.sort(possibilities);
		return possibilities[7];
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			int dX = Integer.parseInt(st.nextToken());
			int dY = Integer.parseInt(st.nextToken());
			for(int xX = 0; xX < dp.length; xX++)
				for(int yY = 0; yY < dp[0].length; yY++)
					dp[x][y] = Integer.MAX_VALUE;
			System.out.println(recurse(0, x -1 , y-1, dX, dY));
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}