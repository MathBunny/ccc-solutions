/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


class Main{
	static class Node{
		ArrayList<Node> tallerThan = new ArrayList<Node>();
		ArrayList<Node> shorterThan = new ArrayList<Node>();
		int visited = 0;
		int ID = 0; //the # of the Node	
		public Node(int ID){
			this.ID = ID;	
		}
	}
	
	public static void main (String [] args){
		new Main();
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			StringTokenizer st = new StringTokenizer(in.readLine());
			int peopleClass = Integer.parseInt(st.nextToken());
			Node [] arr = new Node[peopleClass + 1];
			int comparison = Integer.parseInt(st.nextToken());
			for(int i = 0; i < comparison; i++){
				st = new StringTokenizer(in.readLine());
				int person1 = Integer.parseInt(st.nextToken());
				int person2 = Integer.parseInt(st.nextToken());
				if (arr[person2] == null){
					arr[person2] = new Node(person2);
				}
				if (arr[person1] == null){
					arr[person1] = new Node(person1);
				}
				arr[person1].tallerThan.add(arr[person2]);
				arr[person2].shorterThan.add(arr[person1]);
			}
			st = new StringTokenizer(in.readLine());
			/* now let's see if he's taller? */
			//boolean taller = false;
			int taller = Integer.parseInt(st.nextToken());
			int shorter = Integer.parseInt(st.nextToken());
			
			ArrayDeque <Node> Q = new ArrayDeque<Node>();
			Q.addLast(arr[shorter]);
			while(!Q.isEmpty()){
				int size = Q.size();
				//System.out.println("Size: " + size);
				for(int i = 0; i < size; i++){
					Node temp = Q.removeFirst();
					if (temp.ID == taller){
						System.out.println("yes");
						return;	
					}
					for(int x = 0; x < temp.shorterThan.size(); x++){
						//System.out.println("X: " + x);
						if (temp.shorterThan.get(x).visited == 1){
							//temp.shorterThan.get(x).visited = 0;
						}
						else{
							temp.shorterThan.get(x).visited++;
							Q.addLast(temp.shorterThan.get(x));	
						}
					}	
				}	
			}
			
			Q = new ArrayDeque<Node>();
			Q.addLast(arr[shorter]);
			while(!Q.isEmpty()){
				int size = Q.size();
				for(int i = 0; i < size; i++){
					Node temp = Q.removeFirst();
					if (temp.ID == taller){
						System.out.println("no");
						//System.out.close();
						return;	
					}
					for(int x = 0; x < temp.tallerThan.size(); x++){
						if (temp.tallerThan.get(x).visited > 1){
							//temp.tallerThan.get(x).visited = 0;
						}
						else{
							temp.tallerThan.get(x).visited++;
							Q.addLast(temp.tallerThan.get(x));	
						}
					}	
				}	
			}
			System.out.println("unknown");
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}