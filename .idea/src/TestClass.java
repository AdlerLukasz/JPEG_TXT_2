
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


import javax.imageio.ImageIO;


public class TestClass {


    public static void main(String[] args) throws IOException {



        // Glowny string
        String a = readLast3();
        List<String> arr = new ArrayList<String>(Arrays.asList(a.split("\n")));
        FileWriter writer = new FileWriter("/Users/mac/DEV/output.txt");
        for(String str: arr){
            writer.write(str);
        }
        writer.close();

        System.out.println(a);

        //String text = "Hello";

    /*
       Because font metrics is based on a graphics context, we need to create
       a small, temporary image so we can ascertain the width and height
       of the final image
     */
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(a);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLACK);
        g2d.drawString(a, 0, fm.getAscent());
        g2d.dispose();
        try {
            ImageIO.write(img, "png", new File("/Users/mac/DEV/jpeg.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static String readLast() throws IOException {
        //Drugie podejscie read
        FileReader file = new FileReader("/Users/mac/DEV/LOG.txt");
        List<String> Lines = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            Lines.add(sc.nextLine());
        }
        sc.close();


        String lines = Lines.get(Lines.size()-100);

        return lines;
    }

    public static String readLast2() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/mac/DEV/LOG.txt"));
        String str;

        // do listy i dalej do stringa
        List<String> list = new ArrayList<String>();
        int N = 100; //max number of lines to read
        int counter = 0; //current number of lines already read

        while((str = in.readLine()) !=null  && counter < N){
            list.add(str);
            list.add("\n");

        }




        String a = list.toString();

        return  a;

    }


    public static String readLast3() throws FileNotFoundException{

        ArrayList<String> array = new ArrayList<String>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/mac/DEV/LOG.txt"));
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());

        }
        String line;
        int N = 20;
        int counter = 0;
        try {

            while ((line = reader.readLine()) != null && counter < N) {

                array.add(line + "\n");

                counter++;
            }

            reader.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
        String a = array.toString();
        return a;

    }



}

