/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


public class Main{
	int minMoves = 0;
	
	
	static class Scenario{
		int [] states;
		public Scenario(int [] states){
			this.states = Arrays.copyOf(states, states.length);	
		}	
	}
	
	public static void main (String [] args){
		new Main();
	}
	
	public boolean isEmpty(int [] arr){
		for(int i = 0; i < arr.length; i++){
			if (arr[i] == 1)
				return false;	
		}	
		return true;
	}
	
	public int [] fixArray(int [] arr){
		for(int i = 0; i < arr.length; i++){
			if (arr[i] == 1){
				int length = 0;
				for(int x = i; x < arr.length; x++){
					if (arr[x] == 1)
						length++;
					else
						break;
				}	
				if (length >= 4){
					for(int x = i; x < i + length; x++)
						arr[x] = 0;
				}
				i += (length-1); //is this right?
			}	
		}
		return arr;	
	}
	
	public void outputArr(int [] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			int numLights = Integer.parseInt(in.readLine());
			int [] states = new int[numLights];
			for(int i = 0; i < numLights; i++){
				states[i] = Integer.parseInt(in.readLine());
			}
			ArrayDeque<Scenario> Q = new ArrayDeque<Scenario>();
			HashMap<String, Integer> dp = new HashMap<String, Integer>();
			
			int moves = 0;
			Q.addLast(new Scenario(states));
			while(!Q.isEmpty()){
				int size = Q.size();
				for(int q = 0; q < size; q++){
					Scenario temp = Q.removeFirst();
					if (isEmpty(temp.states)){
						System.out.println(moves);
						return;	
					}else{
						for(int i = 0; i < temp.states.length; i++){
							if (temp.states[i] == 0){
								int [] newArr = Arrays.copyOf(temp.states, temp.states.length);
								newArr[i] = 1;
								newArr = fixArray(newArr);
								String arr = "";
								for(int p = 0; p < newArr.length; p++)
									arr += newArr[p];
								if (dp.get(arr) == null){
									dp.put(arr, moves);
									Q.addLast(new Scenario(newArr));	
								}
								else{
									int val = dp.get(arr);
									if (val != 0 && moves < val){
										dp.put(arr, moves);
										Q.addLast(new Scenario(newArr));			
									}	
								}
									
								//outputArr(newArr);
							}	
						}	
					}
				}	
				moves++;
			}
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}