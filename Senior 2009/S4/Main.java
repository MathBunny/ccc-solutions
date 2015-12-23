/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


public class Main{
	BufferedReader in;
	StringTokenizer st;
	
	public static void main (String [] args){
		new Main();
	}
	
	static class Edge{
		int weight;
		Node destination;
		
		
		public Edge(int weight, Node destination){
			this.weight = weight;
			this.destination = destination;	
		}	
	}
	
	static class Node implements Comparable<Node>{
		int ID;
		ArrayList<Edge> routes = new ArrayList<Edge>();
		int distance = Integer.MAX_VALUE;
		
		public Node(int ID){
			this.ID = ID;	
		}	
		
		public int compareTo(Node o){
			return distance - o.distance; //what lol
		}
	}
	
	static class Store{
		int cost;
		int ID;
		
		public Store(int ID, int cost){
			this.ID = ID;
			this.cost = cost;	
		}
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			//minimum distance from D to K
			int numCities = nextInt();
			int tradeRoutes = nextInt();
			//int [] pencilCosts = new int[
			Node [] cities = new Node[numCities];
			for(int x = 0; x < tradeRoutes; x++){
				int cityA = nextInt() - 1;
				int cityB = nextInt() - 1;
				int cost = nextInt();
				
				if (cities[cityA] == null)
					cities[cityA] = new Node(cityA);
				if (cities[cityB] == null)
					cities[cityB] = new Node(cityB);
				
				cities[cityA].routes.add(new Edge(cost, cities[cityB]));
				cities[cityB].routes.add(new Edge(cost, cities[cityA]));
			}
			
			int numStores = nextInt();
			Store [] pencilCosts = new Store[numCities];
			for(int x = 0; x < numStores; x++){
				int ID = nextInt() - 1;
				int cost = nextInt();
				pencilCosts[x] = new Store(ID, cost);
			}
			int destination = nextInt() -1;
			//if (isGood[destination]){
					
			//}
			
			
			PriorityQueue<Node> Q = new PriorityQueue<Node>();
			cities[destination].distance = 0;
			Q.offer(cities[destination]);
			while(!Q.isEmpty()){
				Node temp = Q.poll();
				for(int x = 0; x < temp.routes.size(); x++){
					if (temp.routes.get(x).destination.distance == Integer.MAX_VALUE || temp.routes.get(x).destination.distance > temp.distance + temp.routes.get(x).weight){
						temp.routes.get(x).destination.distance = temp.distance + temp.routes.get(x).weight;
						Q.offer(temp.routes.get(x).destination);	
					}
				}
			}
			int minCost = Integer.MAX_VALUE;
			for(int x = 0; x < numStores; x++){
				if (pencilCosts[x].cost + cities[pencilCosts[x].ID].distance < minCost)
					minCost = cities[pencilCosts[x].ID].distance + pencilCosts[x].cost;
			}	
			System.out.println(minCost);
			
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