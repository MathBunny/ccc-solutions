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
			//first find all the room sizes
			//then sort the array in order
			//then compute the # of rooms you can fill
			int meters = Integer.parseInt(in.readLine());
			int rows = Integer.parseInt(in.readLine());
			int cols = Integer.parseInt(in.readLine());
			boolean [] [] visited = new boolean[cols][rows];
			String [] [] map = new String[cols][rows];
			
			for(int y = 0; y < rows; y++){
				String input = in.readLine();
				for(int x = 0; x < cols; x++){
					map[x][y] = input.charAt(x) + "";
				}	
			}
			
			ArrayList<Integer> rooms = new ArrayList<Integer>();
			
			
			for(int y = 0; y < rows; y++){
				for(int x = 0; x < cols; x++){
					ArrayDeque<Node> Q = new ArrayDeque<Node>();
					if (visited[x][y] || map[x][y].equals("I"))
						continue;
					Q.addLast(new Node(x, y));
					int surfaceArea = 0;
					while(!Q.isEmpty()){
						int size = Q.size();
						for(int pp = 0; pp < size; pp++){
							Node temp = Q.removeFirst();
							
							if (map[temp.x][temp.y].equals(".") && !visited[temp.x][temp.y])
								surfaceArea++;
							visited[temp.x][temp.y] = true;
							if (temp.x > 0 && !visited[temp.x-1][temp.y] && map[temp.x-1][temp.y].equals("."))
								Q.addLast(new Node(temp.x-1, temp.y));
							if (temp.x < cols-1 && !visited[temp.x+1][temp.y] && map[temp.x+1][temp.y].equals("."))
								Q.addLast(new Node(temp.x+1, temp.y));
							if (temp.y < rows-1 && !visited[temp.x][temp.y+1] && map[temp.x][temp.y+1].equals("."))
								Q.addLast(new Node(temp.x, temp.y+1));	
							if (temp.y >0 && !visited[temp.x][temp.y-1] && map[temp.x][temp.y-1].equals("."))
								Q.addLast(new Node(temp.x, temp.y-1));	
						} 	
					}
					//System.out.println("SA: " + surfaceArea);
					rooms.add(surfaceArea);
				}	
			}
			Collections.sort(rooms);
			//System.out.println(rooms.size());
			int roomsCovered = 0;
			for(int i = rooms.size()-1; i >=0; i--){
				meters-= rooms.get(i);
				if (meters>= 0)
					roomsCovered++;
				else {
					meters+= rooms.get(i);
					break;
				}
			}
			if (roomsCovered == 1)
				System.out.println((roomsCovered + " room, "+ (meters) + " square metre(s) left over"));
			else {
				System.out.println((roomsCovered + " rooms, "+ (meters) + " square metre(s) left over"));
			}
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}