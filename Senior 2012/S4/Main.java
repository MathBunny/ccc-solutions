/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


public class Main{
	public static void main (String [] args){
		new Main();
	}
	
	public String getString(ArrayList<Stack> pos){
		String ret = ""; 
		//ArrayList<Stack> temp = new ArrayList<Stack>(pos);
		for(int x = 0; x < pos.size(); x++){
			Stack<Integer> temp2 = new Stack<Integer>();
			temp2.addAll(pos.get(x));
			int size = temp2.size();
			for(int i = 0; i < size; i++){
				ret += temp2.pop() + "";	
			}	
			ret += "|";
		}
		//System.out.println(ret);
		return ret;
	}
	
	public boolean done(ArrayList<Stack> temp){
		//String out = "";
		for(int x = 0; x < temp.size(); x++){
			if ((temp.get(x).size() != 1) || ((Integer)(temp.get(x).peek()) != (x+1)))
				return false;	
			//else
				//out += " | " + temp.get(x).peek();
		}	
		//System.out.println(out + " -- DONE");
		return true;
	}
	
	public void outputStacks(ArrayList<Stack> temp){
		System.out.print("Output Stack: ");
		for(int x =0; x < temp.size(); x++)
			System.out.print((temp.get(x).size() == 0) ? (" EMPTY ") : (temp.get(x).peek() + " "));	
		System.out.println();
	}
	
	
	//this method does a clean copy
	public ArrayList<Stack> copy (ArrayList<Stack> arr){
		ArrayList<Stack> arrR = new ArrayList<Stack>();
		for(int x = 0; x < arr.size(); x++){
			Stack<Integer> add = new Stack<Integer>();
			add.addAll(arr.get(x));	
			arrR.add(add);
		}
		return arrR;
	}
	
	//need to know when equal, etc.
	public Main(){
		//System.out.println("DIAGNOSE: " + a.size() + " " + b.size());
		
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			
			
			while(true){
				int numberCoins = Integer.parseInt(in.readLine());
				HashMap<String, Integer> dp = new HashMap<String, Integer>(); //use dp for graph theory
				
				if (numberCoins == 0)
					break;
				ArrayList<Stack>pos = new ArrayList<Stack>();
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int x = 0; x < numberCoins; x++){
					pos.add(new Stack<Integer>());
					pos.get(x).push(Integer.parseInt(st.nextToken()));	
				}
				ArrayDeque<ArrayList<Stack>> Q = new ArrayDeque<ArrayList<Stack>>();
				Q.addLast(pos);
				
				boolean possible = false;
				int moves = 0;
				bfs:{
					while(!Q.isEmpty()){
						int size = Q.size();
						//System.out.println("---------------------- Moves:" + moves);
						for(int p = 0; p < size; p++){
							ArrayList<Stack> temp = Q.removeFirst();
							if (done(temp)){
								//System.out.println("DONE");
								possible = true;
								break bfs;
							}
							//go through the array and do every combination possible!
							for(int x = 0; x < temp.size()-1; x++){
								for(int y = x+1; y < temp.size() && y < x+2; y++){ //does this work?
									//System.out.println(temp.get(1).peek() + " = first stack val");
									if (((temp.get(x).size() >= 1 && temp.get(y).size() == 0))|| ((temp.get(x).size() > 0 && temp.get(y).size() > 0) && (Integer)(temp.get(x).peek()) < (Integer)(temp.get(y).peek()))){
										//System.out.println("HERE " + temp.get(0).size() + "vs" + temp.get(1).size() + "vs" + temp.get(2).size());
										ArrayList<Stack> temp2 = copy(temp);//new ArrayList<Stack>(temp); //ignore the dp for now...
										//System.out.println("Check temp2" + temp2.get(0).size() + "vs" + temp2.get(1).size() + "vs" + temp2.get(2).size());
										temp2.get(y).push(temp2.get(x).pop()); //swap!	
										if (dp.get(getString(temp2)) == null){
											Q.addLast(temp2);
											//outputStacks(temp2);
											dp.put(getString(temp2), moves);
											//System.out.println("Check2 after" + temp2.get(0).size() + "vs" + temp2.get(1).size() + "vs" + temp2.get(2).size());
										}
										else{
											/*if (dp.get(getString(temp2)) > moves){
												dp.put(getString(temp2),moves);
												outputStacks(temp2);
												Q.addLast(temp2);
											}	
											else{*/
												//System.out.println("OCCUPIED");	
											//}
										}
									}
									else{
										if (((temp.get(y).size() >= 1 && temp.get(x).size() == 0)) ||  (temp.get(x).size() > 0 && temp.get(y).size() > 0 && (Integer)(temp.get(y).peek()) < (Integer)(temp.get(x).peek()))){
											//System.out.println("GOT HERE2");
											ArrayList<Stack> temp2 = copy(temp);
											temp2.get(x).push(temp2.get(y).pop());
											if (dp.get(getString(temp2)) == null){
												Q.addLast(temp2);
												//outputStacks(temp2);
												dp.put(getString(temp2), moves);
											}
											else{
												/*if (dp.get(getString(temp2)) > moves){
													dp.put(getString(temp2),moves);
													Q.addLast(temp2);
													outputStacks(temp2);
												}	
												else {
													//System.out.println("OCCUPIED 2");
												}*/
											}
										}
										else {
											//System.out.println("NONE OF THE ABOVE " + temp.get(0).size() + "vs" + temp.get(1).size() + "vs" + temp.get(2).size());
										}
									}	
										
								}
							}
							//moves++;
							//now you need to try every combination... 
						}
						moves++;
							
					}	
				}
				if (possible)
					System.out.println(moves);
				else
					System.out.println("IMPOSSIBLE");
				
			}
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}