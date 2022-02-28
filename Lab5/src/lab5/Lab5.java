
package lab5;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;


public class Lab5 {


    public static void main(String[] args) throws IOException {
         File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
       BufferedImage img = ImageIO.read(f1);
       BufferedImage img2 = ImageIO.read(f1);
       int width = img.getWidth();
       int height = img.getHeight(); 
        for(int i =0,k=height-1;i<height;i++,k--){
            for(int j=0;j<width;j++){
            int pixel =img.getRGB(j, i);
             img2.setRGB(j,k,pixel);
            }
        }
       
        File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\2.jpg");
        ImageIO.write(img2, "jpg", f2);
    }
    
}
