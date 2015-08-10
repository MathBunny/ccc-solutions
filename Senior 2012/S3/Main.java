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

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			
			//PrintWriter out = new PrintWriter(new FileWriter(""));
			
			int sensors = Integer.parseInt(in.readLine());
			int [] arr = new int[sensors];
			int [] reading = new int[1001];
			
			for(int i = 0; i < sensors; i++){
				arr[i] = Integer.parseInt(in.readLine());
				reading[arr[i]]++;	
			}
			
			Arrays.sort(arr);
			System.out.println(arr[sensors-1] - arr[0]);
			
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}