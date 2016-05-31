/*
Programming competition file template
Made by Horatiu Lazu
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.text.*;

public class Problem2{
	public static void main (String [] args){
		new Problem2();
	}

	public Problem2(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			int maxWeight = Integer.parseInt(in.readLine());
			int numOfCars = Integer.parseInt(in.readLine());
			ArrayList <Integer> cars = new ArrayList<Integer>();
			
			for(int i =0; i < numOfCars; i++){
				if (i < 4){
					cars.add(Integer.parseInt(in.readLine()));
				}	
				else{
					cars.remove(0);
					cars.add(Integer.parseInt(in.readLine()));
				}
				int sum = 0;
				for(int x = 0; x < cars.size(); x++){
					sum += cars.get(x);
				}
				if (sum > maxWeight){
					System.out.println((i));
					return;	
				}
			}
			System.out.println(numOfCars);
			
		}
		catch(IOException e){
			//System.out.println("IO: General");
		}
	}
	
	
	
}