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
		ArrayList<Integer> friends = new ArrayList<Integer>();
		int ID;
		
		public Node(int ID){
			this.ID = ID;	
		}
			
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			Node [] arr = new Node[50];
			arr[1] = new Node(1);
			arr[1].friends.add(2);
			arr[2] = new Node(2);
			arr[2].friends.add(1);
			arr[3] = new Node(3);
			
			arr[4] = new Node(4);
			arr[5] = new Node(5);
			arr[6] = new Node(6);
			arr[7] = new Node(7);
			arr[8] = new Node(8);
			arr[9] = new Node(9);
			arr[10] = new Node(10);
			arr[11] = new Node(11);
			arr[12] = new Node(12);
			arr[13] = new Node(13);
			arr[14] = new Node(14);
			arr[15] = new Node(15);
			arr[16] = new Node(16);
			arr[17] = new Node(17);
			arr[18] = new Node(18);
			
			while(true){
				
				String command = next();
				if (command.equals("q"))
					break;
				if (command.equals("i")){
					int personA = nextInt();
					int personB = nextInt();
					if (arr[personA] == null){
						arr[personA] = new Node(personA);	
					}	
					if (arr[personB] == null){
						arr[personB] = new Node(personB);	
					}
					
					if (arr[personA].friends.indexOf(personB) == -1)
						arr[personA].friends.add(personB);
					if (arr[personB].friends.indexOf(personA) == -1)
						arr[personB].friends.add(personA);
				}	
				if (command.equals("d")){
					int personA = nextInt();
					int personB = nextInt();
					if (arr[personA] == null){
						arr[personA] = new Node(personA);	
					}	
					if (arr[personB] == null){
						arr[personB] = new Node(personB);	
					}
					int index = arr[personA].friends.indexOf(personB);
					if (index != -1)
						arr[personA].friends.remove(index);
					 index = arr[personB].friends.indexOf(personA);
					if (index != -1)
						arr[personB].friends.remove(index);
				}
				if (command.equals("n")){
					System.out.println(arr[nextInt()].friends.size());	
				}
				if (command.equals("f")){
					int ans = 0;
					int person = nextInt();
					ArrayList<Integer> friends = arr[person].friends;
					if (friends == null)
						System.out.println(0);
					else{
						for(int x = 0; x < friends.size(); x++){
							ArrayList<Integer> fF = new ArrayList<Integer>();
							if (arr[friends.get(x)].friends != null){
								fF = (arr[friends.get(x)].friends);
								for(int y = 0; y < fF.size(); y++){
									if (fF.get(y) != person){
										ans++;	
									}	
								}
							}
							//if (arr[friends.get(x)].frien != person){
								//ans++;	
							//}
						}	
						System.out.println(ans);
					}
				}
				//degrees of seperation
				if (command.equals("s")){
					int start = nextInt();
					int end = nextInt();
					ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
					Q.addLast(start);
					int ans =0;
					boolean found = false;
					boolean [] visited = new boolean[51];
					bfs:{
						while(!Q.isEmpty()){
							int size = Q.size();
							for(int a = 0; a < size; a++){
								int temp = Q.removeFirst();
								if (temp == end){
									System.out.println(ans);
									break bfs;
								}
								for(int x = 0 ; x < arr[temp].friends.size(); x++){
									if (!visited[arr[temp].friends.get(x)]){
										visited[arr[temp].friends.get(x)] = true;
										Q.addLast(arr[temp].friends.get(x));		
									}
									
								}
							}
							ans++;	
						}
					}
					if (!found){
						System.out.println("Not connected");	
					}
					
				}
			}
			
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