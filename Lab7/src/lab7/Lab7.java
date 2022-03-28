package lab7;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Lab7 {

    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\new.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int y = 0; y < height; y++){
             for(int x = 0; x < width; x++ ){
                 
                 int pixel = img.getRGB(x,y);
                 int alpha = (pixel>>24) &0xff;
                 int red = (pixel>>16) &0xff;
                 int green = (pixel>>8) &0xff;
                 int blue = pixel &0xff;
             
                 red = 255 - red;
                 green = 255 - green;
                 blue =  255 - blue;
                 pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                 img.setRGB(x,y,pixel);
             }
        }
        File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\new.jpg");
        ImageIO.write(img, "jpg", f2);
        
    }
    
}