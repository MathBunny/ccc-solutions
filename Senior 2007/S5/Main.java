/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


class Main{
	BufferedReader in;
	StringTokenizer st;
	
	public static void main (String [] args){
		new Main();
	}
	
	public void outputArray(int [] [] arr){
		for(int x = 0; x < arr[0].length; x++){
			for(int y = 0; y < arr.length; y++){
				System.out.print(arr[x][y] +  " ");	
			}
			System.out.println("");
		}	
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int testCases = nextInt();
			for(int qq = 0; qq < testCases; qq++){
				int numPins = nextInt();
				int numBalls = nextInt();
				int width = nextInt();
				int [] pins = new int[numPins];
				for(int x = 0; x < numPins; x++)
					pins[x] = nextInt();
				//now compute best subsequences...
				int [] sum = new int[numPins]; //this is the sum for a single hit of the desired width
				for(int x = 0; x < numPins-width; x++){
					for(int y = 0; y < width; y++){
						sum[x] += pins[x + y];	
					}	
				} 
				for(int x = numPins - width; x < numPins; x++)
					for(int y = x; y < numPins; y++)
						sum[x] += pins[y];
						
				
				//now compute all possibilities (right to left)
				int [] [] dp = new int[numBalls+1][numPins];
				for(int y = 1; y <= numBalls; y++){
					for(int x = numPins-1; x >= 0; x--){
						if (x + width >= numPins){
							dp[y][x] = sum[x];
						}
						else{
							dp[y][x] = Math.max(dp[y][x+1], dp[y-1][x+width] + sum[x]);	
						}
					}
				}
				System.out.println(dp[numBalls][0]);
				
			}
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
	
	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
	   	 	st = new StringTokenizer(in.readLine().trim());
		return st.nextToken();
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	String nextLine() throws IOException {
		return in.readLine().trim();
	}
}