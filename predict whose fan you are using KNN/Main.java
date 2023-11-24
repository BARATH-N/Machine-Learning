package KNN;

import java.util.Scanner;

public class Main {

	static int k_Value = 3;

	public static void main(String[] args) {
		
		
		Read_Store_CSV rsc = new Read_Store_CSV("E:\\Ecli\\CodesPractice\\src\\KNN\\predict_fan.txt");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your name : ");
		
		String userName = input.nextLine();
		
		System.out.println("Age : ");
		
		int userAge = input.nextInt();
		
		System.out.println("Enter your favourite Movie Genre :");
		
		String movieGenre = input.next();
		
		System.out.println("Who is your movie buddy : ");
		
		String buddy = input.next();
	
        rsc.calculate_distance(userAge,rsc.assignFilmGenreNumber(movieGenre),rsc.assignMovieMateNumber(buddy));
	
	    int prediction =  rsc.getMaxPrediction(k_Value);
	    
	    System.out.println();

	   // System.out.println(prediction);
	    
	    if(prediction == 0) {
	    	System.out.println("We predicted that "+ userName + " is a Rajini Fan");
	    }
	    else if(prediction == 1) {
	    	System.out.println("We predicted that "+ userName + " is a JackieChan Fan");

	    }
	    else if(prediction == 2) {
	    	System.out.println("We predicted that "+ userName + " is a Ajith Fan");
	    }
	    else if(prediction == 3) {	    	
	    	System.out.println("We predicted that "+ userName + " is a Kamal Fan");
	    }
	    
	
	}
	
}
