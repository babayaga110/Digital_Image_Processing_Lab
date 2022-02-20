
package lab2;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;


public class Lab2 {

    public static void main(String[] args) throws IOException {
       File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
        BufferedImage img = ImageIO.read(f1);
        int count = 1;
        for(int i =0;i<50;i++){
            for(int j=0;j<50;j++){
            Color c = new Color(img.getRGB(j, i));
            System.out.println("SR. no." + count +" Red: "+c.getRed()+ " Green: " +c.getGreen()+ " Blue: " +c.getBlue());
            count ++;
            }
        }
    }
    
}
