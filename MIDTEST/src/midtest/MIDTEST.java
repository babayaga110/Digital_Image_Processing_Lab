package midtest;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MIDTEST{
    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
        BufferedImage img = ImageIO.read(f1);
        BufferedImage img2 = ImageIO.read(f1);
        File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\Result.jpg");
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i =0;i<height/2;i++){
            for(int j=0,k = (width/2)-1;j<width/2;j++,k--){
            int pixel =img.getRGB(j, i);
                img2.setRGB(k,i,pixel);
            }
        }
         for(int y = 0; y < height/2; y++){
             for(int x = width/2; x < width; x++ ){
                 
                 int pixel = img.getRGB(x,y);
                 int alpha = (pixel>>24) &0xff;
                 int red = (pixel>>16) &0xff;
                 int green = (pixel>>8) &0xff;
                 int blue = pixel &0xff;
             
                 red = 255 - red;
                 green = 255 - green;
                 blue =  255 - blue;
                 pixel = (alpha << 24) | (red << 16) | 
                         (green << 8) | blue;
                 img2.setRGB(x,y,pixel);
             }
        }
        ImageIO.write(img2, "jpg", f2);
    }
    
}
