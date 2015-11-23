/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


class Main{
	public static void main (String [] args){
		new Main();
	}
	
	static class Node{
		int score;
		int level;
		Node left;
		Node right;
		public Node(int s){
			score = s;
			level = 0;
		}
	}
	
	static class Tree{
		Node root;
		public Tree(){
			root = null;	
		}
		public int addL(int s){
			int level = 0;
			if (root == null)
				root = new Node(s);	
			else{
				Node n = root;
				while(true){
					if (s < n.score){
						level += n.level +1;
						if (n.left == null){
							n.left = new Node(s);
							return level;	
						}	
						n = n.left; //works?
					}	
					else{
						n.level++;
						if (n.right == null){
							n.right = new Node(s);
							return level;	
						}	
						n = n.right;
					}
				}	
			}
			return 0;
		}
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			int t = Integer.parseInt(in.readLine());
			Tree tree = new Tree();
			long sum = 0;
			for(int qq =0; qq < t; qq++){
				sum += (long)(tree.addL(Integer.parseInt(in.readLine()))) +1;
				//System.out.println("Sum: " + sum);
			}
			double ans = (double)((double)sum/t);
			//System.out.println(sum);
			DecimalFormat dF = new DecimalFormat("#.##");
			System.out.println(dF.format(ans));
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}