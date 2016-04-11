/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;

/* This method uses difference of arrays. */

class Main{
	BufferedReader in;
	StringTokenizer st;
	
	public static void main (String [] args){
		new Main();
	}
	
	static class Coordinate{
		int x;
		int y;
		boolean isStarted = false;
		int val = 0;
		Coordinate other;
		
		public Coordinate(int x, int y, boolean isStarted, int val){
			this.x = x;
			this.y = y;
			this.isStarted = isStarted;
			this.val = val;	
		}
			
	}
	
	static class sortX implements Comparator<Coordinate>{
		public int compare(Coordinate a, Coordinate b){
			return a.x - b.x;
		}	
	}
	
	static class sortY implements Comparator<Coordinate>{
		public int compare(Coordinate a, Coordinate b){
			return a.y - b.y;
		}	
	}
	
	static class Event implements Comparable<Event>{
		int x;
		int y1;
		int y2;
		int diff = 0;
		int x2;
		
		public Event(int x, int y1,int diff, int x2, int y2){
			this.x = x;
			this.y1 = y1;
			this.diff = diff;	
			this.x2 = x2;
			this.y2 = y2;
		}
		
		public int compareTo(Event e){
			return e.x - x;	
		}
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			//Coordinate compression algorithm
			HashMap<Integer, Integer> toCoordinate = new HashMap<Integer,Integer>();
			HashMap<Integer, Integer> toIndex = new HashMap<Integer, Integer>();
			//Compress X coordinates
			HashMap<Integer, Integer> toCoordinateX = new HashMap<Integer,Integer>();
			HashMap<Integer, Integer> toIndexX = new HashMap<Integer, Integer>();
			//Priority of events
			TreeSet<Integer> order = new TreeSet<Integer>();
			TreeSet<Integer> yVals = new TreeSet<Integer>(); //removes duplicates
			ArrayList<Event> events = new ArrayList<Event>();
			
			int N = nextInt();
			int minValue = nextInt();
			
			for(int x = 0; x < N; x++){
				int topX = nextInt();
				int topY = nextInt();
				int bottomX = nextInt();
				int bottomY = nextInt();
				int val = nextInt();
				order.add(topX);
				order.add(bottomX);
				events.add(new Event(topX, topY, val, bottomX, bottomY));
				//events.add(new Event(bottomX, bottomY, -val, bottomX));
				yVals.add(topY);
				yVals.add(bottomY);
			}
			
			
			/* now compress the y values using HashMap<> */
			int index = 0;
			int lastX = -1;
			for(Integer cord : yVals){
				toCoordinate.put(index, cord);
				toIndex.put(cord, index);
				index++;
			} //good
			long area = 0;
			/* compression on the y axis */
			int oldX = 0;
			long [] [] differenceArray = new long[order.size()][index];
			int count = 0;
			for(Integer e : order){ //compute difference array
				toCoordinateX.put(count, e);
				toIndexX.put(e, count);
				count++;	
			}
			//count /= 2;
			Collections.sort(events);
			
			for(int x = 0; x < events.size(); x++){ //calculate difference array
				int counter = x;
				while(true){
					if (counter == events.size() || events.get(x).x2 < events.get(counter).x){
						break;	
					}
					differenceArray[toIndexX.get(events.get(counter).x)][toIndex.get(events.get(x).y1)] += events.get(x).diff;
					differenceArray[toIndexX.get(events.get(counter).x)][toIndex.get(events.get(x).y2)] += -events.get(x).diff;
					System.out.print(toIndexX.get(events.get(counter).x) + " ");
					counter++;
				}
				System.out.println();
			}
			
			for(int y = 0; y < index-1; y++){ //calculate differnce of arrays
				for(int x = 0; x < count; x++){
					differenceArray[x][y+1] = differenceArray[x][y] + differenceArray[x][y+1];
					System.out.print(differenceArray[x][y+1] + " ");
				}
				System.out.println();
			}
			//now compute the REAL area
			for(int x = 0; x < count; x++){
				for(int y = 0; y < index-1; y++){
					if (differenceArray[x][y] >= minValue){
						area += (toCoordinate.get(y+1) - toCoordinate.get(y)) * (toCoordinateX.get(x+1) - toCoordinateX.get(x));
						System.out.println("From: (" + toCoordinateX.get(x) + ", " + toCoordinate.get(y) + ") to: (" + toCoordinateX.get(x+1) + ", " + toCoordinate.get(y+1) + ")" + " Tint: " + differenceArray[x][y]);
					}	
					else{
						//System.out.println("AREA: " + (toCoordinate.get(y) - toCoordinate.get(y+1)) * (toCoordinate.get(x+1) - toCoordinate.get(x)) + "vs: " + differenceArray[x][y]);
					}
				}	
			}
			System.out.println(area);
			
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