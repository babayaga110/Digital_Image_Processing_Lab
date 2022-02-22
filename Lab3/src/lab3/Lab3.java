
package lab3;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

public class Lab3 {
    public static void main(String[] args) throws IOException {
       File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
       BufferedImage img = ImageIO.read(f1);
       int width = img.getWidth();
       int height = img.getHeight();   
        for(int i =0;i<height;i++){
            for(int j=0;j<width;j++){
            int pixel =img.getRGB(j, i);
             int alpha = pixel >> 24 & 0xff;
             int R = pixel >> 16 & 0xff;
             int G = pixel >> 8 & 0xff;
             int B = pixel >> 0xff;
             int avg = R+G+B/3;
             pixel = alpha << 24 | avg << 16 | avg << 8 | avg;
             img.setRGB(j,i,pixel);
            }
        }
         File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\2.jpg");
        ImageIO.write(img, "jpg", f2);
        
    }
    
}
