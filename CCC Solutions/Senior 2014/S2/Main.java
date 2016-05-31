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
	
	public boolean verify(String [] arr, String [] arr2){
		for(int i = 0; i < arr.length; i++){
			String name = arr[i];
			String 	match = arr2[i];
			if (name.equals(match)){
				return false;	
			}
			boolean found = false;
			for(int x = 0; x < arr.length; x++){
				if (arr2[x].equals(name)){
					if (!found){
						if (arr[x].equals(match))
							found = true;
						else {
						 	return false;
						}
					}	
					else
						return false;
				}
			}
			if (!found)
				return false;
			
		}
		return true;
		
		
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			int students = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			String [] arr = new String[students];
			String [] part = new String[students];
			
			String [] arr2 = new String[students];
			String [] part2 = new String[students];
			
			for(int i = 0; i < students; i++){
				arr[i] = st.nextToken();	
			}
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < students; i++){
				arr2[i] = st.nextToken();
			}
			if (verify(arr, arr2)){
				System.out.println("good");	
			}
			else{
				System.out.println("bad");	
			}
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}