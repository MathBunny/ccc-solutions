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
			int num = Integer.parseInt(in.readLine());
			if (num <= 5){
				System.out.println(num);	
			}
			else{
				System.out.println(num - 5);	
			}
			//if 1, then 1. If two, then 1, 1 or 2, if 3 then 2, 1 or 1
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}