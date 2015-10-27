/* Programming competition file template
Made by Horatiu Lazu */

import java.io.*;
import java.util.*;

class Main{
	int sum = 0;
	
	public static void main (String [] args){new Main();}
	
	public void conditional(int [] patients, int [] bloodSupply, int patientIndex, int bloodSupplyIndex, boolean isNegative){
		if (patients[patientIndex] > bloodSupply[bloodSupplyIndex]){
			sum += bloodSupply[bloodSupplyIndex];
			patients[patientIndex] -= bloodSupply[bloodSupplyIndex];
			bloodSupply[bloodSupplyIndex] = 0;	
		}else{
			sum += patients[patientIndex];
			bloodSupply[bloodSupplyIndex] -= patients[patientIndex];	
			patients[patientIndex] = 0;
		}	
		if (!isNegative){
			if (patients[patientIndex] > bloodSupply[bloodSupplyIndex-1]){
				sum += bloodSupply[bloodSupplyIndex-1];
				patients[patientIndex] -= bloodSupply[bloodSupplyIndex-1];
				bloodSupply[bloodSupplyIndex-1] = 0;	
			}else{
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
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			int [] bloodSupply = new int[8];
			for(int i = 0; i < bloodSupply.length; i++)
				bloodSupply[i] = Integer.parseInt(st.nextToken());
	
			int [] patients = new int[8];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 8; i++)
				patients[i] = Integer.parseInt(st.nextToken());
			
			/* Implementation of efficient algorithm */
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

		}
		catch(IOException e){
			System.out.println("IO: General");
		}
	}
}