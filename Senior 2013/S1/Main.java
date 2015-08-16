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
			String year = (in.readLine());
			for(int i = Integer.parseInt(year)+1;; i++){
				String f = Integer.toString(i);
				boolean [] characters = new boolean[10];
				boolean unique = true;
				for(int x = 0; x < f.length(); x++){
					if (characters[f.charAt(x) - '0']){
						unique = false;
						break;
					}
					else{
						characters[f.charAt(x)-'0'] = true;	
					}
				}	
				if (unique){
					System.out.println(f);
					return;	
				}
			}
			
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}