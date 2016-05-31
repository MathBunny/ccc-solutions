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
	
	/* Bob is sitting at home with his computer. He would like to experience more social interaction, so he is planning a trip to a coffee shop with his computer.

	Bob has lots of data about wireless networks and coffee shops in the city. In Bob's city, there is one coffee shop at every intersection of streets. Specifically, Bob happens to live in a city with MM streets (1≤M≤30,000)(1≤M≤30,000) that run east and west, and NN streets (1≤N≤1,000)(1≤N≤1,000) that run north and south. As an added benefit, the distance between consecutive parallel streets is 1 metre (it is a very compact city).

	It also turns out that inside KK (1≤K≤1,000)(1≤K≤1,000) of the coffee shops, there is a wireless network station. Each wireless network station will have a particular bitrate BB (1≤B≤1,000)(1≤B≤1,000) and can reach RR metres (1≤R≤30,000)(1≤R≤30,000) from the coffee shop. In other words, a wireless network station from one coffee shop forms a circle with radius RR centered at that particular coffee shop. Moreover, if someone is at distance RR, the wireless network would be available, but if someone is at a distance larger than RR, they cannot access that wireless point.

	You can assume that each coffee shop has at most one wireless network stationed in it, but that multiple wireless networks may be available while sitting in that one coffee shop, due to the proximity of other wireless network stations.

	Bob has a special device in his computer that can use all of the available bitrates of as many wireless networks as he can connect to.

	Bob would like to find out the maximum bitrate he can obtain, and how many coffee shops would have that maximum capacity.

	Input Specification

	On the first line of input, you will be given the integer MM, the number of east-west streets. 
	On the second line of input, you will be given the integer NN, the number of north-south streets. 
	On the third line of input, you will be given the integer KK, the number of coffee shops with a wireless network. On the next KK lines, you will have 4 integers per line.

	The first integer xx on each line represents the north-south street on which the coffee shop is located, where 1≤x≤N1≤x≤N. The second integer, yy, on each line represents the east-west street on which the coffee shop is located, where 1≤y≤M1≤y≤M. The third integer, RR, on each line represents the radius of the wireless network from this particular coffee shop. The fourth integer, BB, on each line represents the bitrate of the wireless network from this particular coffee shop. */

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int M = nextInt();
			int N = nextInt();
			int [] [] arr = new int[M+1][N+1];
			int K = nextInt();
			for(int q = 0; q < K; q++){
				int y =  nextInt() - 1; // fix indexing
				int x = M - nextInt();	
				int radius = nextInt();
				int bitRate = nextInt();
				
				int startCircle = Math.max(0, x - radius);
				int endCircle = Math.min(M - 1, x+radius);
				
				for(int circleCord = startCircle; circleCord <= endCircle; circleCord++){
					int leg = Math.abs(circleCord - x);
					//calculate size of circle + add to 2D difference array (well, stack of 1D arrays :p )
					int dist = (int)(Math.sqrt(Math.pow(radius, 2) - Math.pow(leg, 2)));
					//System.out.println(bitRate);
					arr[circleCord][Math.max(0, y - dist)] += bitRate;
					arr[circleCord][Math.min(N, y + dist + 1)] -= bitRate;
				}
			}
			//find max by taking the derivative
			int max = 0;
			int maxFequency = 0;
			for(int x = 0; x < M + 1; x++){
				int currentVal = 0;
				for(int y = 0; y < N + 1; y++){
					currentVal += arr[x][y];
					if (currentVal > max){
						maxFequency = 1;	
						max = currentVal;
					}
					else{
						if (currentVal == max){
							maxFequency++;	
						}	
					}
				}	
			}
			System.out.println(max);
			System.out.println(maxFequency);
			
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