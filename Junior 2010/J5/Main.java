/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


class Main{
	public static void main (String [] args){
		new Main();
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;	
		}	
	}
	
	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			st = new StringTokenizer(in.readLine());
			int dX = Integer.parseInt(st.nextToken())-1;
			int dY = Integer.parseInt(st.nextToken())-1;
			int [] []arr = new int[8][8];
			for(int a = 0; a < 8; a++){
				for(int b =0; b < 8; b++){
					arr[a][b] = Integer.MAX_VALUE;	
				}
			}
			
			ArrayDeque<Node> Q = new ArrayDeque<Node>();
			Q.addLast(new Node(x, y));
			int iterations = 0;
			while(!Q.isEmpty()){
				int size = Q.size();
				for(int pp = 0; pp < size; pp++){
					Node temp = Q.removeFirst();
					if (temp.x == dX && temp.y == dY){
						System.out.println(iterations);
						return;	
					}
					try{
						if (arr[temp.x][temp.y] < iterations){
							continue; //skip it
						}
						else{
							arr[temp.x][temp.y] = iterations;	
						}
					}
					catch(ArrayIndexOutOfBoundsException e){continue;}	
					Q.addLast(new Node(temp.x+1, temp.y+2));
					Q.addLast(new Node(temp.x+1, temp.y+2));
					Q.addLast(new Node(temp.x-1, temp.y-2));
					Q.addLast(new Node(temp.x-1, temp.y+2));
					Q.addLast(new Node(temp.x+2, temp.y+1));
					Q.addLast(new Node(temp.x+2, temp.y-1));
					Q.addLast(new Node(temp.x-2, temp.y-1));
					Q.addLast(new Node(temp.x-2, temp.y+1));
					
				}	
				iterations++;
			}
			System.out.println("IMPOSSIBLE");
			return;
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}