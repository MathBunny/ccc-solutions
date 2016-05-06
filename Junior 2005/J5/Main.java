/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


class Main{
	BufferedReader in;
	StringTokenizer st;
	
	public static void main (String [] args){
		new Main();
	}
	
	public boolean isMonkeyWord(String s){
		
		if (s.length()>0){
			int indexN = s.indexOf("N");
			if (indexN == -1){
				return isAWord(s);	
			}
			boolean shouldCheck = false;
			for(int x = 0; x < s.length(); x++){
				if (s.charAt(x) == 'N'){
					if ((isAWord(s.substring(0, x)) && isMonkeyWord(s.substring(x, s.length()))))
						return true;
					return isAWord(s);
				}	
			}
			return true;
			//return isAWord(s);
		}
		return false;
		
		
		/*
		if (isAWord(s))
			return true;
		
		if (s.indexOf("N") > 0 && s.length() > 2){
			return (isAWord(s.substring(0, s.indexOf("N"))) && isMonkeyWord(s.substring(s.indexOf("N")+1, s.length())));
		}
		
		return false;*/
	}
	
	public boolean isAWord(String s){
		if (s.length() == 1 && s.charAt(0) == 'A'){
			return true;	
		}	
		if (s.length() > 1 && s.charAt(0) == 'B' && s.indexOf("S") > 0){
			//System.out.println(s.substring(1, s.lastIndexOf("S")));
			if (isMonkeyWord(s.substring(1, s.lastIndexOf("S")))){
				return true;	
			}
		}
		return false;
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String input = next();
				if (input.equals("X")){
					return;	
				}	
				if (isMonkeyWord(input)){
					System.out.println("YES");
				}
				else{
					System.out.println("NO");	
				}
			}
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
	
	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
	   	 	st = new StringTokenizer(in.readLine().trim());
		return st.nextToken();
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	String nextLine() throws IOException {
		return in.readLine().trim();
	}
}