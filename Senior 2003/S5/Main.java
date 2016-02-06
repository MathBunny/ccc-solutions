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
	
	static class Node{
		int ID;
		boolean visited = false;
		ArrayList<Edge> bridges = new ArrayList<Edge>();
		
		public Node(int ID){
			this.ID = ID;	
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		Node a;
		Node b;
		int weight;
		
		public Edge(Node a, Node b, int weight){
			this.a = a;
			this.b = b;
			this.weight = weight;	
		}	
		
		public int compareTo(Edge a){
			return a.weight - weight;	
		}
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int minWeight = Integer.MAX_VALUE;
			int c = nextInt();
			int r = nextInt();
			int d = nextInt();
			Node [] cities = new Node[c];
			for(int xX = 0; xX < r; xX++){
				int x = nextInt() - 1;
				int y = nextInt() - 1;
				int w = nextInt();
				if (cities[x] == null)
					cities[x] = new Node(x);
				if (cities[y] == null)
					cities[y] = new Node(y);
				cities[x].bridges.add(new Edge(cities[x], cities[y], w));
				cities[y].bridges.add(new Edge(cities[y], cities[x], w));
			}
			
			boolean [] destination = new boolean[c];
			//int dC = nextInt();
			int cC = d;
			for(int x = 0; x < d; x++)
				destination[nextInt()-1] = true;
			
			PriorityQueue<Edge> Q = new PriorityQueue<Edge>();
			for(int x = 0; x < cities[0].bridges.size(); x++)
				Q.offer(cities[0].bridges.get(x));
			cities[0].visited = true;
			
			Node prev;
			Node prev2;
			
			while(!Q.isEmpty()){
				int size = Q.size();
				for(int xXX =0 ; xXX < size; xXX++){
					Edge temp = Q.poll();
					
					if (temp.b.visited == true){
						continue;
					}
					else{
						temp.b.visited = true;	
					}
					
					if (destination[temp.b.ID]){
						destination[temp.b.ID] = false;	
						cC--;
					}	
					minWeight = Math.min(temp.weight, minWeight);
					if (cC == 0){
						System.out.println(minWeight);
						return;
					}
					
					for(int x = 0; x < temp.b.bridges.size(); x++){
						Q.offer(temp.b.bridges.get(x));	
					}
					
				}	
			}
			System.out.println(-1);
			
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