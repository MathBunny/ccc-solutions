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
	//HashSet<String> cache = new HashSet<String>();
	HashMap<String, Integer> cache = new HashMap<String, Integer>();
	int favourite = 0;
	
	public static void main (String [] args){
		new Main();
	}
	
	boolean [] [] copy(boolean [] [] arr){
		boolean[] [] ret = new boolean[arr.length][arr[0].length];
		
		for(int x = 0; x < arr.length; x++){
			for(int y = 0; y < arr[0].length; y++){
				ret[x][y] = arr[x][y];
			}	
		}	
		return ret;
	}
	
	public int computeWins(boolean [] [] plays, int [] scores, int gamesPlayed){
		if (gamesPlayed == 6){
			int largest = scores[favourite];
			for(int x = 0; x < 4; x++){
				if (scores[x] >= largest && x != favourite)
					return 0;
			}
			//if (cache.contains(Arrays.toString(scores))){
			if (cache.get(Arrays.toString(scores)+Arrays.deepToString(plays)) != null){
				//System.out.println("DUP");
				return 0;
			}
			//System.out.println(Arrays.toString(scores));
			cache.put(Arrays.toString(scores) + Arrays.deepToString(plays), 1);
			//System.out.println("OK: " + largest);
			return 1;
		}
		int ans = 0;
		for(int x = 0; x < 3; x++){
			for(int y = x+1; y < 4; y++){
				if (!plays[x][y]){
					//win loss and draw
					//plays[
					boolean [] [] scenario = copy(plays);
					int [] scoresWin = Arrays.copyOf(scores, scores.length);
					scenario[x][y] = true;
					scoresWin[x]+= 3;
					ans += computeWins(scenario, scoresWin, gamesPlayed+1);
					
				    boolean [] [] scenario2 = copy(plays);
				    int [] scoresWin2 = Arrays.copyOf(scores, scores.length);
					scenario2[x][y] = true;
					scoresWin2[x]++;
					scoresWin2[y]++;
					ans += computeWins(scenario2, scoresWin2, gamesPlayed+1);
					
					 boolean [] [] scenario3 = copy(plays);
				    int [] scoresWin3 = Arrays.copyOf(scores, scores.length);
					scenario3[x][y] = true;
					//scoresWin[x]++;
					scoresWin3[y]+=3;
					ans += computeWins(scenario3, scoresWin3, gamesPlayed+1);
				}
			}	
		}
		return ans;
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
		 	favourite = nextInt() - 1;
			int gamesPlayed = nextInt();
			boolean played [] [] = new boolean[4][4];
			int [] score = new int[4];
			for(int q = 0; q < gamesPlayed; q++){
				int teamA = nextInt()-1;
				int teamB = nextInt()-1;
				int scoreA = nextInt();
				int scoreB = nextInt();
				if (scoreA > scoreB)
					score[teamA] += 3;
				else if (scoreB > scoreA)
					score[teamB] += 3;
				else{
					score[teamA]++;
					score[teamB]++;	
				}
				played[Math.min(teamA, teamB)][Math.max(teamB, teamA)] = true;
			}
			System.out.println(computeWins(played, score, gamesPlayed));
			
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