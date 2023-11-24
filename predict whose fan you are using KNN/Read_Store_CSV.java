package KNN;

import java.io.*;
import java.util.Arrays;

public class Read_Store_CSV {
	
	
	int[] age = new int[15];
	
	int[] filmGenre = new int[15];
	
	int[] movieMate = new int[15];
	
	public int output[] = new int[15];

	double[] ls = new double[15];
	
	public Read_Store_CSV(String filepath){
		
		String file = filepath;
		
		BufferedReader reader = null;
		
		String line = "";
		
		int index = 0;
		
		try {
			
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null) {
				
				String[] row = line.split(",");
				
				age[index] = Integer.parseInt(row[1]);
				
				filmGenre[index] = assignFilmGenreNumber(row[2]);
			
				movieMate[index] = assignMovieMateNumber(row[3]);
				
				output[index] = assignOutput(row[4]);
						
				index++;
				
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
//		for(int i=0;i<age.length;i++) {
//			System.out.println(age[i]+" "+filmGenre[i]+" "+movieMate[i]+" "+output[i]);
//		}
	}

	private int assignOutput(String stars) {
		
		if(stars.equals("Rajini")) {
			return 0;
		}
		else if(stars.equals("JackieChan")) {
			return 1;
		}
		else if(stars.equals("Ajith")) {
			return 2;
		}
		else if(stars.equals("Kamal")) {
			return 3;
		}
		return 0;
		
	}

	public int assignFilmGenreNumber(String filmGenre) {
		
		if(filmGenre.equals("Comedy")) {
			return 0;
		}
		else if(filmGenre.equals("Action")) {
			return 1;
		}
		else if(filmGenre.equals("Romance")) {
			return 2;
		}
		else if(filmGenre.equals("Cartoon")) {
			return 3;
		}
		
		return 1;
		
	}

	public int assignMovieMateNumber(String movieMate) {
		
		if(movieMate.equals("Friends")) {
			return 0;
		}
		else if(movieMate.equals("Lover")) {
			return 1;
		}
		else if(movieMate.equals("Family")) {
			return 2;
		} 
		
		return 3;
		
	}

	public void calculate_distance(int userAge, int movieGenre, int buddy) {
		
		for(int i=0; i<age.length; i++) {
			
			int ageDiff = age[i] - userAge;
			
			int filmDiff = filmGenre[i] - movieGenre;
			
			int mateDiff = movieMate[i] - buddy;
			
			ls[i] = Math.sqrt( (ageDiff * ageDiff) + (filmDiff * filmDiff) + (mateDiff * mateDiff)) ;
			
			
		}
		
		sortOutput();
		
	}

	public void sortOutput() {
	
	     for(int i=0;i<ls.length;i++) {
	    	 
	    	 for(int j=i+1; j<ls.length ; j++) {
	    		 
	    		 if(ls[i]>ls[j]) {
	    			 
	    			 double temp = ls[i];
	    			 ls[i] = ls[j];
	    			 ls[j] = temp;
	    			 
	    			 int tempOut = output[i];
	    			 output[i] = output[j];
	    			 output[j] = tempOut;
	    			 
	    		 }
	    		 
	    	 }
	   
	    }

	         System.out.println("Distance           "+" Output");

	     for(int i=0;i<ls.length;i++) {
	    	 System.out.printf(ls[i]+"           "+output[i]);
	    	 System.out.println();
	     }
	     
	    
    	 System.out.println();
    	 System.out.println(Math.sqrt(ls[0]));


	
    }

	public int getMaxPrediction(int k_Value) {
		
		double sum = 0;
        for(int i=0;i<k_Value;i++) {
	    	 sum+=output[i];
	     }
        System.out.println("Accuracy  " + (100 - ((output[0]/sum) * 100)) + " %");
		
		int count = 1;
		int max = 1;
	    int predictValue = 0;
        for(int i=1;i<k_Value;i++) {
			
			if(output[i]==output[i-1]) {
				count++;
			}
        }
        if(count == 1) {
        	return output[0];
        }
        count = 1;
		for(int i=1;i<k_Value;i++) {
			
			if(output[i]==output[i-1]) {
				count++;
			}
			else {
				count = 1;
			}
			if(count > max) {
				max = count;
				predictValue = output[i-1];
			}
		}
	
		return predictValue;
		
	}

	

	
}