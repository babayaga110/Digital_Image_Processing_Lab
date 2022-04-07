
package lab8;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Lab8 {

    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
        BufferedImage img = ImageIO.read(f1);
        BufferedImage img2 = ImageIO.read(f1);
        File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\Result.jpg");
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i =height-1,k=0;i>=height/2;i--,k++){
            for(int j=0;j<width;j++){
            int pixel =img.getRGB(j, i);
                img2.setRGB(j,k,pixel);
            }
        }
        for(int y = height/2; y < height; y++){
             for(int x = 0; x < width; x++ ){
                 
                 int pixel = img.getRGB(x,y);
                 int alpha = (pixel>>24) &0xff;
                 int red = (pixel>>16) &0xff;
                 int green = (pixel>>8) &0xff;
                 int blue = pixel &0xff;
             
//                 red = 255 - red;
                 blue = 255 - blue;
                 pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                 img2.setRGB(x,y,pixel);
             }
        }
         
        ImageIO.write(img2, "jpg", f2);
    }
    
}
