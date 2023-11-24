package KNN;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java
public class Test{

	long red=0,green=0,blue=0;
	
	long pixel = 256 * 256;

	public void dotesting(File path) {
		
		try {
			
			BufferedImage test_image = ImageIO.read(path);
		     test_image = re(test_image);
		     get_rgb(test_image);
		     System.out.println(red+" "+green+" "+blue);
		     
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	}

	private void get_rgb(BufferedImage test_image) {
		long rgb = 0;
		for(int x=0; x<test_image.getHeight(); x++) {
			   for(int y=0; y<test_image.getWidth(); y++) {
				 
				   
			    	rgb = (int)(test_image.getRGB(x,y));
				    red += ((rgb >> 16 ) & 0xFF);
				    green += ((rgb >> 8 ) & 0xFF);
				    blue += (rgb  & 0xFF);
		       }
		}
		red = red/pixel;
		green = green/pixel;
		blue = blue/pixel;
	}

	private BufferedImage re(BufferedImage image) {
       
		BufferedImage resizedImage = new BufferedImage(256,256,BufferedImage.TYPE_INT_RGB);
		
		Graphics2D graphics2d = resizedImage.createGraphics();
		
		graphics2d.drawImage(image,0,0,256,256,null);
		
		graphics2d.dispose();
	    
	 //   System.out.print(" "+resizedImage.getHeight()+" "+resizedImage.getWidth()+" ");
		return resizedImage;
	}

	
	
}
