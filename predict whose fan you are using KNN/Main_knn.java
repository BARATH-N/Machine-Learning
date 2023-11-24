package KNN;

import java.io.File;


public class Main_knn {
	public static void main(String[] args) {
		
		String path = "E:\\Ecli\\CodesPractice\\res\\neem_images";
		File directoryPath = new File(path);
		Store_DB database = new Store_DB(directoryPath);
    	Train train = new Train(directoryPath);
		File test_path = new File("E:\\Ecli\\CodesPractice\\res\\neem_images\\Banana.jpg");
	     Test test = new Test();
	     test.dotesting(test_path);
		//database.print();
	}
	
	
}
