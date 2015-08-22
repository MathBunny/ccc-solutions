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
			int dictated = Integer.parseInt(in.readLine());
			Stack a = new Stack<Integer>();
			
			for(int i = 0; i < dictated; i++){
				int num = Integer.parseInt(in.readLine());
				if (num == 0){
					a.pop();	
				}
				else{
					a.push(num);	
				}
			}
			Integer sum = 0;
			while(!a.isEmpty()){
				sum += (Integer)a.pop();
			}
			System.out.println(sum);
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}