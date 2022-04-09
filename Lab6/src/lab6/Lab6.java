package lab6;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

public class Lab6 {

    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
       BufferedImage img = ImageIO.read(f1);
       BufferedImage img2 = ImageIO.read(f1);
       BufferedImage img3 = ImageIO.read(f1);
       int width = img.getWidth();
       int height = img.getHeight(); 
       for(int i =0;i<height;i++){
            for(int j=0,k = width-1;j<width;j++,k--){
            int pixel =img.getRGB(j, i);
             img2.setRGB(k,i,pixel);
            }
        }
        for(int i =0,n=height-1;i<height;i++,n--){
            for(int j=0;j<width;j++){
            int pixel =img2.getRGB(j, i);
             img3.setRGB(j,n,pixel);
            }
        }
        File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\5.jpg");
        ImageIO.write(img3, "jpg", f2);
    }
    
}
