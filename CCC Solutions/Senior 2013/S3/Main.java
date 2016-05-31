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
	
    static class Scenario{
		boolean teamsPlayed[] [];
		int [] teamScores;
		
		public Scenario(boolean teamsPlayed [] [], int [] teamScores){
			this.teamsPlayed = Arrays.copyOf(teamsPlayed, teamsPlayed.length);
			this.teamScores = Arrays.copyOf(teamScores, teamScores.length);
		}
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			
			//PrintWriter out = new PrintWriter(new FileWriter(""));
			int favouriteTeam = Integer.parseInt(in.readLine());
			int gamesPlayed = Integer.parseInt(in.readLine());
			
			boolean teamsPlayed [] [] = new boolean[4][4];
			
			int [] teamScores = new int[4];
			
			/* This code gets all of the different player configurations. */
			for(int i = 0; i < gamesPlayed; i++){
				StringTokenizer st = new StringTokenizer(in.readLine());
				int team1 = Integer.parseInt(st.nextToken());
				int team2 = Integer.parseInt(st.nextToken());
				int score1 = Integer.parseInt(st.nextToken());
				int score2 = Integer.parseInt(st.nextToken());
				if (score2 > score1){
					teamScores[team2-1]+=3;
				}
				else if (score2 == score1){
					teamScores[team1-1]++;
					teamScores[team2-1]++;
				}
				else{
					teamScores[team1-1]+=3;
				}
				teamsPlayed[team1-1][team2-1] = true;
				teamsPlayed[team2-1][team1-1] = true;
			}
			
			/* Now we need to generate every type of game. */
			ArrayDeque<Scenario> possibilities = new ArrayDeque<Scenario>();
			possibilities.addLast(new Scenario(teamsPlayed, teamScores));
			for(int a = 0; a < 3; a++){ //team A
				for(int b = a + 1; b < 4; b++){
					int size = possibilities.size();
					ArrayList<Scenario> addBack = new ArrayList<Scenario>();
					for(int p = 0; p < size; p++){
						Scenario temp = possibilities.removeFirst();
						if (temp.teamsPlayed[a][b] == false){
							System.out.println("Got here!");
							//hasNew = true;
							temp.teamsPlayed[a][b] = true;
							temp.teamsPlayed[b][a] = true;
							temp.teamScores[a]+=3;
							Scenario add = new Scenario(temp.teamsPlayed, temp.teamScores);
							possibilities.addLast(add);
							temp.teamScores[a]-=2;
							temp.teamScores[b]++;
							Scenario tie = new Scenario(temp.teamsPlayed, temp.teamScores);
							possibilities.addLast(tie);
							temp.teamScores[a]--;
							temp.teamScores[b]+=2;
							Scenario lost = new Scenario(temp.teamsPlayed, temp.teamScores);
							possibilities.addLast(lost);
						}
						else{
							addBack.add(temp);	
						}
					}
					for(int i = 0; i < addBack.size(); i++){
						possibilities.addLast(addBack.get(i));	
					}
					
				}
			}	
			
			int won = 0;
			System.out.println("size; " + possibilities.size());
			while(!possibilities.isEmpty()){
				Scenario temp = possibilities.removeFirst();
				int largest = 0;
				int secondLargest = 0;
				for(int i = 0; i < 4; i++){
					if (temp.teamScores[i] > largest){
						largest = temp.teamScores[i];
					}
					if (temp.teamScores[i] > secondLargest && temp.teamScores[i] <= largest){
						secondLargest = temp.teamScores[i];	
					}
				}
				if (secondLargest != largest){
					if (temp.teamScores[favouriteTeam-1] == largest){
						won++;	
					}	
				}
			}
			System.out.println(won);
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}