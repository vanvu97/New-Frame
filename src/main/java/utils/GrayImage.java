package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GrayImage {

    private static String a;
    private static String b;

    public static int c[];

    public static void setA(String a) {
        GrayImage.a = a;
    }

    public static void setB(String b) {
        GrayImage.b = b;
    }
    public static void setC(int[] c) {
        GrayImage.c = c;
    }


    public static void main() throws IOException, InterruptedException {

        GrayImage ex5 = new GrayImage();

        BufferedImage img = null;
        File f = null;
        // read image
        try {
            f = new File(a);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }

        // get image's width and height
        int width = img.getWidth();
        int height = img.getHeight();

        // convert to grayscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // Here (x,y)denotes the coordinate of image
                // for modifying the pixel value.
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int R = (p >> 16) & 0xff;
                int G = (p >> 8) & 0xff;
                int B = p & 0xff;

//=======================================
                // calculate average
                int avg = (r + g + b) / 3;
                // replace RGB value with avg
                p = (a << c[0]) | (avg << c[1]) | (avg << c[2])| avg;
//=======================================
//                r = 255 - r;
//                g = 255 - g;
//                b = 255 - b;
//                // set new RGB value
//                p = (a << 24) | (r << 16) | (g << 8) | b;
//=======================================
                // calculate newRed, newGreen, newBlue
//                int newRed = (int)(0.393 * R + 0.769 * G
//                        + 0.189 * B);
//                int newGreen = (int)(0.349 * R + 0.686 * G
//                        + 0.168 * B);
//                int newBlue = (int)(0.272 * R + 0.534 * G
//                        + 0.131 * B);
//
//                // check condition
//                if (newRed > 255)
//                    R = 255;
//                else
//                    R = newRed;
//
//                if (newGreen > 255)
//                    G = 255;
//                else
//                    G = newGreen;
//
//                if (newBlue > 255)
//                    B = 255;
//                else
//                    B = newBlue;
//
//                // set new RGB value
//                p = (a << 24) | (R << 16) | (G << 8) | B;
//=======================================

                img.setRGB(x, y, p);
            }
        }
        // write image
        try {
            f = new File(b);
            ImageIO.write(img, "png", f);
            System.out.println("Conver Completed!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
