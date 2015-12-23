/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


public class Main{
	public static void main (String [] args){
		new Main();
	}
	
	static class Person{
		int ID = 0;
		int prevIteration = 0;
		ArrayList<Person> friends = new ArrayList<Person>();
		
		public Person(int ID){
			this.ID = ID;
		}	
		
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			int students = Integer.parseInt(in.readLine());
			int assignments = students;
			
			Person [] arr = new Person[10000];
			for(int p = 0; p < assignments; p++){
				StringTokenizer st = new StringTokenizer(in.readLine());
				int personA = Integer.parseInt(st.nextToken()) -1;
				int personB = Integer.parseInt(st.nextToken()) -1;
				if (arr[personA] == null)
					arr[personA] = new Person(personA);
				if (arr[personB] == null)
					arr[personB] = new Person(personB);
				arr[personA].friends.add(arr[personB]);
				//arr[personB].friends.add(arr[personA]);
			}
			String input;	
			int iteration = 1;
			while(true){
				input = in.readLine();
				if (input.equals(""))
					return;
				StringTokenizer st = new StringTokenizer(input);
				int personA = Integer.parseInt(st.nextToken()) -1;
				int personB = Integer.parseInt(st.nextToken()) -1;
				if (personA == -1 && personB == -1)
					return;
				int steps = 0;
				boolean found = false;
				ArrayDeque<Person> Q = new ArrayDeque<Person>();
				if (arr[personA] == null){
					System.out.println("No");
					continue;	
				}
				Q.addLast(arr[personA]);
				search:{
					while(!Q.isEmpty()){
						int size = Q.size();
						for(int p = 0; p < size; p++){
							Person temp = Q.removeFirst();
							if (temp == null)
								continue;
							temp.prevIteration = iteration;
							if (temp.ID == personB){
								found = true;
								break search;	
							}
							for(int x = 0; x < temp.friends.size(); x++){
								if (temp.friends.get(x).prevIteration != iteration)
									Q.addLast(temp.friends.get(x));	
							}
						}	
						steps++;
					}
				}
				if (found){
					System.out.println("Yes " + (steps-1));
				}
				else
					System.out.println("No");
				iteration++;
			}
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}