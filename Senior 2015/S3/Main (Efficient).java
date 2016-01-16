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
			int G = nextInt();
			int P = nextInt();
			TreeSet<Integer> Q = new TreeSet<Integer>();
			for(int x = 1; x <= G; x++)
				Q.add(x); //free gates
			
			int ans = 0;
			for(int i = 0; i < P; i++){
				int max = nextInt();
				if (Q.floor(max) == null)
					break;	
				Q.remove(Q.floor(max));
				ans++;
			}
			System.out.println(ans);
			
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