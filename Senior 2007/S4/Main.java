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
		int x;
		long visited;
		ArrayList<Node> edges = new ArrayList<Node>();
		
		public Node(int x){
			this.x = x;
		}
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			int markedPoints = nextInt();
			Node [] points = new Node[markedPoints];
			while(true){
				int nodeA = nextInt() -1;
				int nodeB = nextInt() -1;
				if (nodeA == -1 && nodeB == -1)
					break;
				if (points[nodeA] == null)
					points[nodeA] = new Node(nodeA);
				if (points[nodeB] == null)
					points[nodeB] = new Node(nodeB);
				points[nodeA].edges.add(points[nodeB]);
			}
			ArrayDeque<Node> Q = new ArrayDeque<Node>();
			if (points[0] == null){
				System.out.println(0);
				return;
			}
			points[0].visited = 1;
			long waysVisited = 1;
			boolean [] visited = new boolean[markedPoints];
			Q.addLast(points[0]);
			while(!Q.isEmpty()){
				int size = Q.size();
				for(int p = 0; p < size; p++){
					Node temp = Q.removeFirst();
					//add it to all the exits
					for(int x = 0; x < temp.edges.size(); x++){
						temp.edges.get(x).visited += temp.visited;
						if (!visited[temp.edges.get(x).x]){
							visited[temp.edges.get(x).x] = true;
							Q.addLast(temp.edges.get(x));	
						}	
					}
				}	
			}
			if (points[markedPoints-1] == null)
				System.out.println(0);
			else
				System.out.println(points[markedPoints-1].visited);
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