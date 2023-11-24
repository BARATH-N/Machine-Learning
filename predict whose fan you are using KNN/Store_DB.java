package KNN;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Store_DB {

    
	
	File[] files;
	
	public Store_DB(File directoryPath) {
		
		files = directoryPath.listFiles();
	}
	
	
	
	
	





	public void print () {
		int count = 0;
		for(File file : files) {
			if(file.isFile()) {
			   count++;
			}
		}
		System.out.println(count);
	}
	
	
}
