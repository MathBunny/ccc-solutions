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
	
	public Path2D.Double combinations(int x1, int x2, int y1, int y2, Path2D.Double aaa){
		for(int x =0; x < 3; x++)
			for(int y = 0; y < 3; y++)
				aaa.lineTo(valu(x), valu(y));
		return aaa;
	}	
	
	public double valu(int num){
		if (num == 0)
			return -0.1;
		if (num == 1)
			return 0;
		return 0.1;
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int x1 = nextInt();
			int y1 = nextInt();
			int x2 = nextInt();
			int y2 = nextInt();
			
			Line2D.Double a = new Line2D.Double(x1, y1, x2, y2);
			Path2D.Double aaa = new Path2D.Double();
			aaa.moveTo(x1, y1);
			aaa = combinations(x1, x2, y1, y2, aaa);
			aaa.closePath();
			
			int numBuilds = nextInt();
			Polygon [] buildings = new Polygon[numBuilds];
			for(int x = 0; x < numBuilds; x++){
				int numPoints = nextInt();
				int [] xCord = new int[numPoints];
				int [] yCord = new int[numPoints];
				for(int y = 0; y < numPoints; y++){
					xCord[y] = nextInt();
					yCord[y] = nextInt();
				}
				buildings[x] = new Polygon(xCord, yCord, numPoints); 
				
			}
			Area aa = new Area(aaa);
			Area [] arr = new Area[numBuilds];
			for(int x = 0; x < numBuilds; x++)
				arr[x] = new Area(buildings[x]);
			int count = 0;
			for(int x = 0; x < numBuilds; x++){
				aa.intersect(arr[x]);
				if (!aa.isEmpty()){
					//System.out.println("yes");
					count++;	
				}	
				else{
					//System.out.println("no");	
				}
				aa = new Area(aaa);
			}
			System.out.println((count));
			
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