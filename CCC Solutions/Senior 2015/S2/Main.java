/* Programming competition file template
 Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


public class Main{
	public static void main (String [] args){
		new Main();
	}
	
	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			//PrintWriter out = new PrintWriter(new FileWriter(""));
			int numJerseys  = Integer.parseInt(in.readLine());
			int customers = Integer.parseInt(in.readLine());
			int [] jersey = new int[numJerseys];
			for(int qq = 0; qq < numJerseys; qq++){
				String input = in.readLine();
				if (input.equals("L")){
					jersey[qq] = 2;
				}
				if (input.equals("M")){
					jersey[qq] = 1;
				}
				if (input.equals("S")){
					jersey[qq] = 0;
				}
			}
			int sum = 0;
			boolean [] used = new boolean[numJerseys];
			
			for(int i = 0; i < customers; i++){
				StringTokenizer st =  new StringTokenizer(in.readLine());
				String sizeS = (st.nextToken());
				int size = -1;;
				if (sizeS.equals("L")){
					size = 2;
				}
				if (sizeS.equals("M")){
					size = 1;
				}
				if (sizeS.equals("S")){
					size = 0;
				}
				int num = Integer.parseInt(st.nextToken());
				if (jersey[num - 1] >= size){
					if (used[num-1] == false){
						sum++;
						used[num-1] = true;
					}
				}                          
			}
			System.out.println(sum);
			
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}