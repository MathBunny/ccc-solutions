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

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int T = nextInt();
			for(int q = 0; q < T; q++){ //simple math
				int N = nextInt();
				int M = nextInt() ;
				int S = nextInt();	
				M = M % (N); //+1?
				//System.out.println(M);
				int pos = S+M-1;
				//System.out.println(pos);
				pos = (pos) % (N);
				if (pos == 0)
					pos = N;
				System.out.println(pos);
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