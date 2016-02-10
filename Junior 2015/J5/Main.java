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
	
	int [] [] [] dp;

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int N = nextInt();
			int K = nextInt();
			dp = new int[N+1][K+1][N+1];
			
			for(int x = 0; x < N+1; x++)
				for(int y =0 ; y < K+1; y++)
					for(int z = 0; z < N+1; z++)
						dp[x][y][z] = -1;
			System.out.println(solve(N, K, 1));
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
	
	private int solve (int N, int K, int prev) {
		if (dp[N][K][prev] != -1)
			return dp[N][K][prev];
		if (N == 0 && K == 0)
			return dp[N][K][prev] = 1;
		if (N == 0 || K == 0)
			return dp[N][K][prev] = 0;
		dp[N][K][prev] = 0;
		for (int next = prev; next <= N; next++)
			dp[N][K][prev] += solve(N - next, K - 1, next);
		return dp[N][K][prev];
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