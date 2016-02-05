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
	
	public void outputList(ArrayList<Integer> nums, int num){
		for(int x = 0; x < nums.size(); x++){
			System.out.print(nums.get(x) + " ");
				
		}	
		System.out.println(" | " + num);
	}
	
	public int findPos(ArrayList<Integer> arr, int num){
		int low = 0;
		int high = arr.size();
		int prevDiff = Integer.MAX_VALUE;
		
		while(low <= high){
			//System.out.println("Low: " + low + " " + high);
			int mid = low + (high-low)/2;
			if (mid == arr.size()-1 && num < arr.get(mid)){
				return -1;	
			}
			if (mid == 0 && num > arr.get(mid)){
				return 0;	
			}
			if (mid == 0 || mid == arr.size()-1)
				return mid;
			if (arr.get(mid) < num && arr.get(mid-1) > num){
				return mid;	
			}
			
			if (low == high){
				high++;
				low++;	
			}
			else if (arr.get(mid) < num){
				//outputList(arr, num);
				//System.out.println("Less: " + arr.get(mid) + "compared with: " + num + "Low: " + low + "medium: " + mid + "high: " + high);
				high = mid;	
			}
			else if (arr.get(mid) == num){
				low++;
				//System.out.println("Equal: " + arr.get(mid) + "compared with: " + num);
				//low = mid;
			}
			else if (low == high){
				high++;
				low++;	
			}
			else{
				//System.out.println("Greater: " + arr.get(mid) + "compared with: " + num);
				low = mid;	
			}
			
		}
		return Integer.MAX_VALUE;
	}

	public Main(){
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new FileReader("s5.3.in"));
			double res = 0;
			int games = Integer.parseInt(in.readLine());
			
			ArrayList<Integer> scores = new ArrayList<Integer>();
			for(int qq = 0; qq < games; qq++){
				//System.out.println(qq + " = progress");
				int score = Integer.parseInt(in.readLine());
				if (scores.size() == 0){
					res = 1;
					scores.add(score);
					continue;
				}
				int resP = findPos(scores, score);
				if (resP == -1){
					scores.add(score);
					//System.out.println(resP+1 + " of: " + (qq+1));
					res = (res * qq + (qq+1))/(qq+1);
				}
				else{
					scores.add(resP, score);
					//System.out.println(resP+1 + " of: " + (qq+1));
					res = (res * qq + (resP+1))/(qq+1);
				}
				//binary search	
				
			}
			DecimalFormat dF = new DecimalFormat("0.00");
			System.out.println(dF.format(res));
			
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