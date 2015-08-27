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
			
			String input = in.readLine();
			int sum = 0;
			for(int i = 0; i < input.length(); i+=2){
				int num = input.charAt(i) - '0';
				char character = input.charAt(i+1);
				int base = 0;
				if (character == 'I'){
					base = 1;
				}	
				else if (character == 'V')
					base = 5;
				else if (character == 'X')
					base = 10;
				else if (character == 'L')
					base = 50;
				else if (character == 'C')
					base = 100;
				else if (character == 'D')
					base = 500;
				else if (character == 'M')
					base = 1000;
				else{
					System.out.println("hi");	
				}
				if (num > base && i != 0){
					sum -= num * base;
				}
				else{
					sum += num * base;	
				}
				//System.out.println(sum);
			}
			System.out.println(sum);
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}