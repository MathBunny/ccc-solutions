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
	int [] [] [] dp;
	int N;
	
	public static void main (String [] args){
		new Main();
	}
	
	public int solve(int leftN, int leftK, int maxChoose){
		//System.out.println(leftN + " " + leftK + " " + maxChoose);
		if (leftK == 0 && leftN == 0){
			return 1;	
		}	
		if (leftK <= 0 || leftN <= 0){
			dp[leftN][leftK][maxChoose] = 0;
			return 0;
		}
		if (dp[leftN][leftK][maxChoose] != -1){
			//System.out.println("OK!");
			//dp[leftN][leftK][maxChoose] = 0;
			return dp[leftN][leftK][maxChoose];
		}	
		
		int ans = 0;
		dp[leftN][leftK][maxChoose] = 0;
		for(int x = maxChoose; x <= leftN; x++){
			dp[leftN][leftK][maxChoose] += solve(leftN - x, leftK-1, x);
		}
		return dp[leftN][leftK][maxChoose];
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			N = nextInt();
			int K = nextInt();
			dp = new int[N+1][K+1][N+1];
			for(int x = 0; x < N+1; x++){
				for(int y = 0; y < K+1; y++){
					for(int z =0; z < N+1; z++){
						dp[x][y][z] = -1;	
					}	
				}	
			}
			System.out.println(solve(N, K, 1));
			
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