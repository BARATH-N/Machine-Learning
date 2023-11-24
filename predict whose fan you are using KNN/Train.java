package KNN;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Train extends Store_DB{
	
	BufferedImage image = new BufferedImage(240,240,BufferedImage.TYPE_INT_ARGB);
	
	static long redValues[] = new long[15];
	static long greenValues[] = new long[15];
	static long blueValues[] = new long[15];
	long rgb =  0;
	long num = 256 * 256;
	FileWriter writer;
	public Train(File directoryPath) {
		super(directoryPath);
		
	    this.addRGBValuesForEachImage();

	    this.printrgbValues();
	}

	

	private void printrgbValues() {
		for(int i=0;i<13;i++) {
			System.out.println(redValues[i]+" "+greenValues[i]+" "+blueValues[i]);
		}
		
	}

	public void addRGBValuesForEachImage() {
		
		
		int index = 0;
		try {
			writer = new FileWriter("rgb_DB.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<files.length;i++) {
		
			try {
				
				image = ImageIO.read(files[i]);
				
				long rgb = 0;
			    long red = 0, green = 0, blue = 0;
			    image = resize_image(image);
			    int height = image.getHeight();
				int width = image.getWidth();
				//System.out.println(height+" "+width);
				
				for(int x=0; x<height; x++) {
					   for(int y=0; y<width; y++) {
						 
						   
					    	rgb = (int)(image.getRGB(x,y));
						    red += ((rgb >> 16 ) & 0xFF);
						    green += ((rgb >> 8 ) & 0xFF);
						    blue += (rgb  & 0xFF);
				       }
				}
			
				redValues[index]= red/this.num;
				greenValues[index] = green/this.num;
				blueValues[index] = blue/this.num;
				 
				 writer.write(redValues[index]+","+greenValues[index]+","+blueValues[index]+"\n");
				index++;
 				this.rgb = 0;
				
				} catch (IOException e) {
     			e.printStackTrace();
     			}
		}
			

			
		
		
		
		
	}

	public BufferedImage resize_image(BufferedImage image) throws IOException {
		
		BufferedImage resizedImage = new BufferedImage(256,256,BufferedImage.TYPE_INT_RGB);
		
		Graphics2D graphics2d = resizedImage.createGraphics();
		
		graphics2d.drawImage(image,0,0,256,256,null);
		
		graphics2d.dispose();
	    
	 //   System.out.print(" "+resizedImage.getHeight()+" "+resizedImage.getWidth()+" ");
		return resizedImage;
	}
	
	
	
}
