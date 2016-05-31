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
	
	static class Node implements Comparable<Node>{
		long distance = -1;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		public int compareTo(Node a){
			if (distance > a.distance)
				return -1;
			else
				return 1;
			//return distance - a.distance;	
		}
	}
	
	static class Edge{
		Node start;
		Node end;
		int weight = 0;
		public Edge(Node start, Node end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;	
		}	
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int numCities = nextInt();
			int numRoads = nextInt();
			Node [] cities = new Node[numCities];
			for(int x = 0; x < numRoads; x++){
				int a = nextInt();
				int b = nextInt();
				int weight = nextInt();
				if (cities[a] == null)
					cities[a] = new Node();
				if (cities[b] == null)
					cities[b] = new Node();
				cities[a].edges.add(new Edge(cities[a], cities[b], weight));
			}
			PriorityQueue<Node> Q = new PriorityQueue<Node>();
			cities[0].distance = 0;
			Q.offer(cities[0]);
			while(!Q.isEmpty()){
				int size = Q.size();
				for(int x = 0; x < Q.size(); x++){
					Node temp = Q.poll();
					for(int y = 0; y < temp.edges.size(); y++){
						if (temp.edges.get(y).end.distance == -1 || temp.distance + temp.edges.get(y).weight > temp.edges.get(y).end.distance){
							temp.edges.get(y).end.distance = temp.distance + temp.edges.get(y).weight;
							Q.offer(temp.edges.get(y).end);
						} 	
					}	
				}	
			}
			System.out.println(cities[cities.length-1].distance);
			
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