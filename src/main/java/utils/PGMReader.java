package utils;

import model.PGMStructure;

import java.io.*;
import java.util.Scanner;

/**
 * Created by BurakMac on 21/12/15.
 */
public class PGMReader {
    private String fileName;

    public PGMStructure readFile() throws IOException {
        System.out.println("Path => " + getClass().getResource("playground.pgm").getPath());
        InputStream fileInputStream = getClass().getResourceAsStream("playground.pgm");
//        FileInputStream fileInputStream = new FileInputStream(new File("./playground.pgm"));


        Scanner scan = new Scanner(fileInputStream);
// Discard the magic number
        scan.nextLine();
// Discard the comment line
        scan.nextLine();
// Read pic width, height and max value
        PGMStructure pgmStructure = new PGMStructure();
        pgmStructure.setWidth(scan.nextInt());
        pgmStructure.setHeight(scan.nextInt());
        pgmStructure.setMaxVal(scan.nextInt());

        fileInputStream.close();

        // Now parse the file as binary data
        fileInputStream = getClass().getResourceAsStream("playground.pgm");
        DataInputStream dis = new DataInputStream(fileInputStream);

        // look for 4 lines (i.e.: the header) and discard them
        int numnewlines = 4;
        while (numnewlines > 0) {
            char c;
            do {
                c = (char) (dis.readUnsignedByte());
            } while (c != '\n');
            numnewlines--;
        }
        int height = pgmStructure.getHeight();
        int width = pgmStructure.getWidth();
        int[][] temp = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                temp[row][col] = dis.readUnsignedByte();
                //System.out.print(temp[row][col] + " ");
            }
            //System.out.println();
        }

        pgmStructure.setImage(new int[pgmStructure.getWidth()][pgmStructure.getHeight()]);
        pgmStructure.setHeight(width);
        pgmStructure.setWidth(height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pgmStructure.getImage()[col][height - row - 1] = temp[row][col];
                //System.out.print(pgmStructure.getImage()[col][row] + " ");
            }
            //System.out.println();
        }

        pgmStructure.setPatternSize(3);
        return pgmStructure;
    }
}

