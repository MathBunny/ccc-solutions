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
			int testCases = Integer.parseInt(in.readLine());
			for(int qq = 0; qq < testCases; qq++){
				int N = Integer.parseInt(in.readLine());
				ArrayList<Integer> branch = new ArrayList<Integer>();
				int done = 0;
				int currentNum = 1;
				int currentIndex = 0;
				
				int [] nums = new int[N];
				for(int i = N - 1; i >=0; i--){
					nums[i] = Integer.parseInt(in.readLine());
				}
				boolean isPossible = true;
				while(true){
					if (done == N){
						System.out.println("Y");
						break;	
					}
					if (currentNum == N && (branch.size() == 0 || branch.get(branch.size() - 1) != currentNum)){
						System.out.println("N");
						break;	
					}
					
					if (currentIndex < N && nums[currentIndex] == currentNum){
						currentNum++;
						done++;
						currentIndex++;	
					}
					else if (branch.size() != 0 && branch.get(branch.size() - 1) == currentNum){
						done++;
						currentNum++;
						branch.remove(branch.size() - 1);
					}
					else{
						if (currentIndex < N){
							branch.add(nums[currentIndex]);
							currentIndex++;
						}
						else{
							System.out.println("N");
							break;	
						}
					}
					
				}					
			}
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}