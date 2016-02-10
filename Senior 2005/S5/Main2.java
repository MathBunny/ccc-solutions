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
	static double count = 0;
	
	public static void main (String [] args){
		new Main();
	}


	public static void mergeSort (int[] a, int x, int z){
		if (x < z){
			 int y = (x + z) / 2;
			 mergeSort (a, x, y);
			 mergeSort (a, y + 1, z);
			 count += merge (a, x, y, z);
		}
	}


	public static double merge (int[] a, int x, int y, int z){
		int[] newa = new int [z - x + 1];
		int xx = x;
		int yy = y + 1;
		int k = 0;
		double total = 0;
		while (xx <= y && yy <= z)
			if (a [xx] <= a [yy])
				newa [k++] = a [xx++];
			else{
				newa [k++] = a [yy++];
				total = total + (y + 1 - xx);
			 }
		while (xx <= y)
			newa [k++] = a [xx++];
		while (yy <= z)
			newa [k++] = a [yy++];
		for (xx = x ; xx <= z ; xx++)
			 a [xx] = newa [xx - x];
		return total;
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int N = nextInt();
			int [] arr = new int[N];
			for(int x =0 ; x < N; x++)
				arr[x] = nextInt();
			mergeSort(arr, 0, N-1);
			DecimalFormat dF = new DecimalFormat("#.00"); //count = 11 .. 6 + 5 || divided by 5.
			//System.out.println(count + " " + N);
			System.out.println(dF.format((double)((double)(((double)((count))) + N)/N)));
			
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