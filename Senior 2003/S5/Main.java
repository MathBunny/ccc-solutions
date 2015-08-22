/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


class Main{
	class Road implements Comparable<Road>{
		int cityA;
		int cityB;
		int weight;
		
		public Road (int cityA, int cityB, int weight){
			this.cityA = cityA;
			this.cityB = cityB;
			this.weight = weight;
		}
		
		public int compareTo(Road o){
			if (o.weight > weight){
				return 1; //0?	
			}	
			return 0;
		}
		
	}
	public static void main (String [] args){
		new Main();
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			StringTokenizer st = new StringTokenizer(in.readLine());
			int cities = Integer.parseInt(st.nextToken());
			int roads = Integer.parseInt(st.nextToken());
			int destinationCities = Integer.parseInt(st.nextToken());
			int destinationCitiesHit = 0;
			
			Road [] network = new Road[roads];
			boolean [] isDestination = new boolean[cities +1];
			
			for(int i = 0; i < roads; i++){
				st = new StringTokenizer(in.readLine());
				network[i] = new Road(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			for(int i = 0; i < destinationCities; i++){
				int num = Integer.parseInt(in.readLine());
				isDestination[num] = true; 
			}
			
			Arrays.sort(network);
			int smallestWeight = Integer.MAX_VALUE;
			for(int i = 0; i < network.length; i++){
				if (network[i].weight < smallestWeight)
					smallestWeight = network[i].weight;
				if (isDestination[network[i].cityB]){
					destinationCitiesHit++;
					isDestination[network[i].cityB] = false;
				}
				if (isDestination[network[i].cityA]){
					destinationCitiesHit++;
					isDestination[network[i].cityA] = false;
				}
				if (destinationCitiesHit == destinationCities)
					break;
			}
			System.out.println(smallestWeight);
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}