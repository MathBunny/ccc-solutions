/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


class Main{
	public static void main (String [] args){
		new Main();
	}
	
	/** Optimized on find: Find O(1) */
	static class DisjointSet{
		int head = -1;
		int id;
		boolean isHead = false;
		
		void setHead(){
			isHead = true;	
		}
		
		void removeHead(){
			isHead = false;	
		}
		
		void set(int new){
			this.head = head;
		}
		
		int find(int find){
			return head;
		}		
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			int gatesNum = Integer.parseInt(in.readLine());
			int planes = Integer.parseInt(in.readLine());
			DisjointSet [] gates = new DisjointSet[gatesNum];
			int sum = 0;
			for(int i = 0; i < planes; i++){
				int maxGate = Integer.parseInt(in.readLine());
				if (gates[maxGate].head == -1){
					if (maxGate == 1){
						gates[maxGate].head = 0;	
					}else{
						
					}
				}
				if (gates.head == 0 && maxGate == 1){
					break;	
				}
				sum++;
			}
			System.out.println(sum);
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}