/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.security.*;


class Main{
	public static void main (String [] args){
		new Main();
	}
	
 	static class Node{
		int x;
		int y;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;	
		}
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			
			//PrintWriter out = new PrintWriter(new FileWriter(""));
			StringTokenizer st = new StringTokenizer(in.readLine());
			int rows = Integer.parseInt(st.nextToken());
			int cols = Integer.parseInt(st.nextToken());
			int cages = Integer.parseInt(in.readLine());
			boolean [][] cagesMap = new boolean [rows][cols];
			int [][] dp = new int[rows][cols];
			for(int i = 0; i < cages; i++){
				st = new StringTokenizer(in.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				cagesMap[row - 1][col - 1] = true;
			}
			/* Now find the shortest path. */
			//ArrayDeque <Node> Q = new ArrayDeque<Node>();
			//int sum = 0;
			dp[0][0] = 1;
			for(int x = 0; x < rows; x++){
				for(int y = 0; y < cols ; y++){
					if (!cagesMap[x][y]){
						int sum2 = 0;
						try{
							if (!cagesMap[x-1][y]){
								sum2 += dp[x-1][y];
								//System.out.println("DP: " + dp[x-1][y]);
							}
						}
						catch(IndexOutOfBoundsException eee){
								
						}	
						try{
							if (!cagesMap[x][y-1]){
								sum2 += dp[x][y-1];
							}
						}
						catch(IndexOutOfBoundsException eee){
							
						}	
						dp[x][y] += sum2;
						//System.out.println("WORKS!" + sum2);
					}
					else{
						
					}
					
				}	
			}
			System.out.println(dp[rows-1][cols-1]);
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}