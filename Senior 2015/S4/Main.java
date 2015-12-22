/* Programming competition file template
 Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;

class Route{
	Island a;
	Island b;
	int wear;
	int time;
	public Route(Island a, Island b, int wear, int time){
		this.a = a;
		this.b = b;
		this.wear = wear;
		this.time = time;
	}
	
}

class Island{
	int time;
	int wear;
	int num;
	ArrayList<Route> routes = new ArrayList<Route>();
	boolean [] visited; //visited array
	
	
	public Island(int wear, int num){
		this.wear = wear;
		this.num = num;
	}
	
}

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
			StringTokenizer st = new StringTokenizer(in.readLine());
			int thickness = Integer.parseInt(st.nextToken());
			int islandsNum = Integer.parseInt(st.nextToken());
			int routes = Integer.parseInt(st.nextToken());
			Island [] islands = new Island[islandsNum];
			
			for(int i = 0; i < routes; i++){
				st = new StringTokenizer(in.readLine());
				int is1 = Integer.parseInt(st.nextToken()) - 1;
				int is2 = Integer.parseInt(st.nextToken()) - 1;
				if (islands[is1] == null){
					islands[is1] = new Island(thickness, is1);
					islands[is1].visited = new boolean[islandsNum];
				}
				if (islands[is2] == null){
					islands[is2] = new Island(thickness, is2);
					islands[is2].visited = new boolean[islandsNum];
				}
				int times = Integer.parseInt(st.nextToken());
				int wear = Integer.parseInt(st.nextToken());
				islands[is1].routes.add(new Route(islands[is1], islands[is2], wear, times));
				islands[is2].routes.add(new Route(islands[is2], islands[is1], wear, times));
			}
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			int minTime =Integer.MAX_VALUE;
			ArrayDeque <Island> Q = new ArrayDeque<Island>();
			Q.addLast(islands[start]);
			while(!Q.isEmpty()){
				int size = Q.size();
				//System.out.println(size);
				for(int qq = 0; qq < size; qq++){
					Island temp = Q.removeFirst();
					if (temp.num == end){
						if (minTime > temp.time){
							minTime = temp.time;
						}
					}
					for(int i = 0; i < temp.routes.size(); i++){
						Route tempR = temp.routes.get(i);
						
						int rWear = temp.routes.get(i).wear;
						int time = temp.time;
						//System.out.println(temp.wear + "-" + rWear);
						if (temp.wear - rWear > 0 && time + temp.routes.get(i).time < minTime && !temp.visited[temp.routes.get(i).b.num]){
							Island newIsland = new Island(temp.wear - tempR.wear, temp.routes.get(i).b.num);
							//System.out.println(temp.routes.get(i).b.num);
							newIsland.routes = temp.routes.get(i).b.routes;
							newIsland.time += temp.time + temp.routes.get(i).time;
							boolean arr [] = Arrays.copyOf(temp.visited, temp.visited.length);
							arr[temp.routes.get(i).b.num] = true;
							newIsland.visited = arr;
							Q.addLast(newIsland);
						}
						
					}
				}
			}
			if (minTime == Integer.MAX_VALUE){
				System.out.println(-1);
			}
			else{
				System.out.println(minTime);
			}
			
			
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}