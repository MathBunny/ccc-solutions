/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;


class Main{
	int sum = 0;
	
	public static void main (String [] args){
		new Main();
	}
	
	public void conditional(int [] patients, int [] bloodSupply, int patientIndex, int bloodSupplyIndex, boolean isNegative){
		if (patients[patientIndex] > bloodSupply[bloodSupplyIndex]){
			//System.out.println("ADDED: " + bloodSupply[bloodSupplyIndex] + "from: " + patientIndex +" using" + bloodSupplyIndex);
			sum += bloodSupply[bloodSupplyIndex];
			patients[patientIndex] -= bloodSupply[bloodSupplyIndex];
			bloodSupply[bloodSupplyIndex] = 0;	
		}else{
			//System.out.println("ADDED2: " + patients[patientIndex] + "from: " + patientIndex +" using" + bloodSupplyIndex);
			sum += patients[patientIndex];
			bloodSupply[bloodSupplyIndex] -= patients[patientIndex];	
			patients[patientIndex] = 0;
		}	
		if (!isNegative){
			if (patients[patientIndex] > bloodSupply[bloodSupplyIndex-1]){
				//System.out.println("ADDED: " + bloodSupply[bloodSupplyIndex-1] + "from: " + patientIndex +" using" + (bloodSupplyIndex-1));
				sum += bloodSupply[bloodSupplyIndex-1];
				patients[patientIndex] -= bloodSupply[bloodSupplyIndex-1];
				bloodSupply[bloodSupplyIndex-1] = 0;	
			}else{
				//System.out.println("ADDED2: " + patients[patientIndex] + "from: " + patientIndex +" using" + (bloodSupplyIndex-1));
				sum += patients[patientIndex];
				bloodSupply[bloodSupplyIndex-1] -= patients[patientIndex];	
				patients[patientIndex] = 0;
			}	
		}
	}

	public Main(){
		try{
			BufferedReader in;
			in = new BufferedReader (new InputStreamReader (System.in)); //Used for CCC
			//in = new BufferedReader(new FileReader("A.in")); //Used for JDCC & others
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int [] bloodSupply = new int[8];
			for(int i = 0; i < bloodSupply.length; i++)
				bloodSupply[i] = Integer.parseInt(st.nextToken());
				
			
			int [] patients = new int[8];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 8; i++)
				patients[i] = Integer.parseInt(st.nextToken());
			
			
			/* Implementation of efficient algorithm */
			//method signature:
			//public void conditional(int [] patients, int [] bloodSupply, int patientIndex, int bloodSupplyIndex, boolean isNegative)
			conditional(patients,bloodSupply, 0, 0,true);
			conditional(patients,bloodSupply,1,1,false);
			
			conditional(patients,bloodSupply,2,2,true);
			conditional(patients,bloodSupply,2,0,true);
			conditional(patients,bloodSupply,3,3,false);
			conditional(patients,bloodSupply,3,1,false);
			
			conditional(patients,bloodSupply,4,4,true);
			conditional(patients,bloodSupply,4,0,true);
			conditional(patients,bloodSupply,5,5,false);
			conditional(patients,bloodSupply,5,1,false);
			
			for(int i = 0; i < 7; i+=2)
				conditional(patients,bloodSupply,6,i,true);
				
			for(int i = 0; i < 8; i++) /* should you include the previous? */
				conditional(patients,bloodSupply,7,i,true);
			
			System.out.println(sum);
			
			
			/* Type O patient */
			/*
			if (oNegative > patients[0]){
				sum += patients[0];
				oNegative -= patients[0];
				patients[0] = 0;	
			}
			else{
				sum += oNegative;
				patients[0] -= oNegative;
				oNegative = 0;	
			}
			
			if (oNegative != 0){
				if (oNegative > patients[1]){
					sum += patients[1];
					oNegative -= patients[1];
					patients[1] = 0;	
				}
				else{
					patients[1] -= oNegative;
					sum += oNegative;
					oNegative = 0;
				}
			}	
			if (oPositive > patients[1]){
				sum += patients[1];
				oPositive -= patients[1];
				patients[1] = 0;	
			}
			else{
				sum += oPositive;
				patients[1] -= oPositive;
				oPositive = 0;
			}	
			
			
			TYPE A: if (aNegative > patients[2]){
					
			}
			*/
			
			
			//out.close();
			
		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}