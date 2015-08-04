/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


public class  Main{
	public static void main (String [] args){
		new Main();
	}
	int bestMoves = Integer.MAX_VALUE;
	int [] [] map = new int[9][9];
	public int solve(int x, int y, int dx, int dy, int moves){
		if ((map[x][y] == 0 || map[x][y] >= moves) && x == dx && y == dy && x > 0 && x <= 8 && y > 0 && y <= 8){
			if (moves < bestMoves)
				bestMoves = moves;
			return 0;
		}
		if (x > 0 && x <= 8 && y > 0 && y <= 8 && (map[x][y] < moves || map[x][y] == 0))
			return 0;
		if (!(x > 0 && x <= 8 && y > 0 && y <= 8))
			return 0;
		map[x][y] = moves; //sketchy
		return solve(x+2, y+1, dx, dy, moves+1) + solve(x+2, y-1, dx, dy, moves+1) + solve(x+1, y-2, dx, dy, moves+1)  + solve(x-1, y-2, dx, dy, moves+1)  + solve(x+1, y+2, dx, dy, moves+1) + solve(x-1, y+2, dx, dy, moves+1)  + solve(x-2, y-1, dx, dy, moves+1) + solve(x-2, y+1, dx, dy, moves+1);
		
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			
			solve(x, y, dx, dy, 0);
			System.out.println(bestMoves);
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}