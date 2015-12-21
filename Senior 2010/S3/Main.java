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

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			
			int numHouses = Integer.parseInt(in.readLine());
			int houses [] = new int[numHouses];
			for(int x = 0; x < houses.length; x++){
				String input = in.readLine();
				if (input.equals("0 "))
					houses[x] = 0;
				else
					houses[x] = Integer.parseInt(input);
			}
			Arrays.sort(houses);
			
			int numHydrants = Integer.parseInt(in.readLine());
			
			if (numHydrants >= numHouses){
				System.out.println("0");
				return;	
			}
			
			int hoseLength = 1;
			//simulate stretching the rope from one house to anoehr
			for(hoseLength = 1; hoseLength<1000000; hoseLength++){
				int hydrants = numHydrants; //greedily pair them up
				//int completed =0;
				//go sequentially through all the gaps, if you cannot place one then you need to go to the next...
				for(int x = 0; x < numHouses; x++){
					hydrants--;
					if (hydrants < 0)
						break; 
					int loc = houses[x]+hoseLength*2; //length
					int progress = 0;
					for(int y = x; y < numHouses; y++){
						if (loc >= houses[y]){
							//System.out.println("Loc: " + loc);
							progress++;
						}
					}
					x += (progress - 1);
				}
				if (hydrants >= 0){
					System.out.println(hoseLength);
					return;	
				}
			}
			
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
		catch(NumberFormatException e){
			System.out.println(e);	
		}
	}
}