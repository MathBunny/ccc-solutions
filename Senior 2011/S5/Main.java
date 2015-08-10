/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


class Main{
	
	public static class Lights{
		int focus = 0; //wtf?
		int [] state;
		public Lights(int [] state){
			this.state = Arrays.copyOf(state, state.length);	
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
			
			//PrintWriter out = new PrintWriter(new FileWriter(""));
			int lights = Integer.parseInt(in.readLine());
			int [] state = new int[lights];
			for(int i = 0; i < lights; i++)
				state[i] = Integer.parseInt(in.readLine());
			ArrayDeque<Lights> Q = new ArrayDeque<Lights>();
			Q.addLast(new Lights(state));
			int moves = 0;
			
			BFS: {while(!Q.isEmpty()){
				
				int size = Q.size();
				for(int p = 0; p < size; p++){
					Lights temp = Q.removeFirst();
					int [] arr = Arrays.copyOf(temp.state, temp.state.length);
					
					/* Verify groupings. */
					int currentSize = 0;
					for(int i = 0; i < arr.length; i++){
						if (arr[i] == 1)
							currentSize++;
						if (arr[i] == 0){
							if (currentSize >= 4){
								for(int o = i; o > o - currentSize; o--){ //> ???
									arr[o] = 0;
								}	
							}
							currentSize = 0;
						}
					}
					if (currentSize >= 4){
						for(int i = arr.length-1; i >= arr.length-1-currentSize; i--){
							arr[i] = 0;	
						}	
					}
					
					boolean foundOne = false;
					for(int i = 0; i < arr.length; i++){
						if (arr[i] == 1){
							foundOne = true;
							break;
						}
					}
					if (!foundOne){
						break BFS;	
					}
					for(int i = 0; i < arr.length; i++){
						if (arr[i] != 0){
							int [] newArr = Arrays.copyOf(arr, arr.length);
							newArr[i] = 1;
							Q.addLast(new Lights(newArr));
						}
					}
				}
				moves++;
			}
			}
			
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}