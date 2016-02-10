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
	
	//public int dist (int x1, int y1, int x2, int y2){
		//return Math.ceil(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
	//}
	
	public int findYValue(int x1, int y1, int x2, int radius, boolean isPlus){
		return (int)((y1 + Math.sqrt((int)(radius * radius - ((x2-x1) * (x2-x1))))));
	}
	
	public int findYValue(int x1, int y1, int x2, int radius){
		return (int)((y1 - Math.sqrt((int)(radius * radius - ((x2-x1) * (x2-x1))))));
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			//System.out.println(findYValue(0, 0, 1, 5));
			int M = nextInt();
			int N = nextInt();
			int [] [] map = new int[N][M];
			int K = nextInt();
			int [] xCord = new int[K];
			int [] yCord = new int[K];
			int [] radius = new int[K];
			int [] bitRate = new int[K];
			for(int x = 0; x < K; x++){
				yCord[x] = nextInt()-1;
				xCord[x] = nextInt()-1;
				radius[x] = nextInt();
				bitRate[x] = nextInt();
			}
			for(int q =0; q < K; q++){
				for(int x = Math.max(xCord[q]-radius[q], 0); x <= Math.min(xCord[q] + radius[q], M-1); x++){
					//map[left] = Math.max(0, yCord[q] - 
					
					int val = Math.min(M-1, (findYValue(xCord[q], yCord[q], x, radius[q], false)));
					map[x][val] += bitRate[q];
					System.out.println("Circle #" + q + " " + yCord[q] + " " + (x*2 + (findYValue(xCord[q], yCord[q],x, radius[q], true))));
					//if (yCord[q] - findYValue(xCord[q], yCord[q],x, radius[q], true) >= M)
						//val = M-1;
					//else
					val = Math.min(M-1, (findYValue(xCord[q], yCord[q],x, radius[q], true)));
					map[x][val] -= bitRate[q];
				}
			} //differnce of arrays
			//now reverse difference of array
			int max = 0;
			int num = 1;
			for(int x = 0; x < N; x++){
				if (map[x][0] == max)
					num++;
				for(int y = 0; y < M-1; y++){
					map[x][y+1]=map[x][y] + map[x][y+1]; 	
					if (map[x][y+1] > max){
						max = map[x][y+1];
						num = 1;
						System.out.println("Coordinate: (" + x + ", " + (y+1) + ")");
					}
					else{
						if (map[x][y+1] == max){
							num++;	
							System.out.println("Coordinate: (" + x + ", " + (y+1) + ")");
						}
					}
				}
			}
			System.out.println(max);
			System.out.println(num);
			
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