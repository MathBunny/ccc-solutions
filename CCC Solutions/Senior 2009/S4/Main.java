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
		int distance = 100000000;
		
		public Node(int ID){
			this.ID = ID;	
		}	
		
		public int compareTo(Node o){
			return distance - o.distance; //what lol
		}
	}
	
	static class Store{ //don't need this anymore!
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
			int [] [] adjacencyMatrix = new int[numCities][numCities];
			int [] minDistance = new int[numCities];
			Arrays.fill(minDistance, 100000000);
			//Arrays.fill(adjacencyMatrix, -1);
			
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
				adjacencyMatrix[cityA][cityB] = cost;
				adjacencyMatrix[cityB][cityA] = cost;
				
				//cities[cityA].routes.add(new Edge(cost, cities[cityB]));
				//cities[cityB].routes.add(new Edge(cost, cities[cityA]));
			}
			
			int numStores = nextInt();
			int [] pencilCosts = new int[numCities];
			Arrays.fill(pencilCosts, -1);
			for(int x = 0; x < numStores; x++){
				int ID = nextInt() - 1;
				int cost = nextInt();
				pencilCosts[ID] = cost;
			}
			int destination = nextInt() -1;
			//if (isGood[destination]){
					
			//}
			int minCost = 100000000;
			
			Queue<Node> Q = new LinkedList<Node>();
			//PriorityQueue<Node> Q = new PriorityQueue<Node>();
			minDistance[destination] = 0;
			//cities[destination].distance = 0;
			Q.offer(cities[destination]);
			while(!Q.isEmpty()){
				Node temp = Q.poll();
				for(int x = 0; x < numCities; x++){
					if (adjacencyMatrix[temp.ID][x] != 0 && (minDistance[x] == 100000000 || minDistance[x] > minDistance[temp.ID] + adjacencyMatrix[temp.ID][x])){
						minDistance[x] = minDistance[temp.ID] +  adjacencyMatrix[temp.ID][x];
						if (pencilCosts[x] != -1 && minDistance[x] < minCost){
							//System.out.println(minCost);
							minCost = Math.min(minDistance[x] + pencilCosts[x], minCost);
							Q.offer(cities[x]);	
						}
						else{
							if (pencilCosts[x] == -1){ //why>
								Q.offer(cities[x]);	
							}	
						}
						//Q.offer(temp.routes.get(x).destination);	
					}
				}
			}
			
			for(int x = 0; x < numCities; x++){
				if (pencilCosts[x] != -1 && pencilCosts[x] + minDistance[x] < minCost && minDistance[x] != 100000000){
					minCost = minDistance[x] + pencilCosts[x];
				}
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