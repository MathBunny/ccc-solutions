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
			int questions = Integer.parseInt(in.readLine());
			String [] given = new String[questions];
			String [] ans = new String[questions];
			for(int i = 0; i < questions; i++)
				given[i] = in.readLine();
			for(int i =0 ; i < questions; i++)
				ans[i] = in.readLine();
			int right = 0;
			for(int i = 0; i < questions; i++)
				if (given[i].equals(ans[i]))
					right++;
			System.out.println(right);
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}