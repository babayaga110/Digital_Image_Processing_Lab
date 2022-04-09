package lab7;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Lab7 {

    public static void main(String[] args) throws IOException {
//        negativeTransformation();
        logTransformation();
//        gammaTransformation();
    }
 
    static void negativeTransformation() throws IOException{
        File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
        File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\negativeTransformation.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int pixel = img.getRGB(x,y);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;

                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                img.setRGB(x, y, pixel);

            }
        }
        ImageIO.write(img,"jpg", f2);
    }
     static void logTransformation() throws IOException{
        File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
        File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\logTransformation2.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++) {
                int pixel = img.getRGB(x, y);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;
             
                red = (int) (255 * Math.log(1 + red));
                green = (int) (255 * Math.log(1 + green));
                blue = (int) (255 * Math.log(1 + blue));

                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                img.setRGB(x, y, pixel);
            }
        }
        ImageIO.write(img,"jpg", f2);
    }
     static void gammaTransformation() throws IOException{
        File f1 = new File("C:\\Users\\DarkMoon\\Desktop\\1.jpg");
        File f2 = new File("C:\\Users\\DarkMoon\\Desktop\\gammaTransformation.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++) {

                int pixel = img.getRGB(x, y);
                int alpha = (pixel >> 24) & 0xff;
                double red = (pixel >> 16) & 0xff;
                double green = (pixel >> 8) & 0xff;
                double blue = pixel & 0xff;

                //gamma transformation

                red = 255 * Math.pow(red / 255, 0.4);
                green = 255 * Math.pow(green / 255, 0.4);
                blue = 255 * Math.pow(blue / 255, 0.4);

                pixel = (alpha << 24) | ((int) red << 16) | ((int) green << 8) | (int) blue;
                img.setRGB(x, y, pixel);
            }
        }
        ImageIO.write(img,"jpg", f2);
    }
}