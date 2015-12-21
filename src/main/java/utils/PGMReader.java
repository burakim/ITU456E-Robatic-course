package utils;

import model.PGMStructure;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by BurakMac on 21/12/15.
 */
public class PGMReader {
    private String fileName;

    public PGMStructure readFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(getClass().getResource("/utils/playground.pgm").getPath()));
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
        fileInputStream = new FileInputStream(new File(getClass().getResource("/utils/playground.pgm").getPath()));
        DataInputStream dis = new DataInputStream(fileInputStream);

        // look for 4 lines (i.e.: the header) and discard them
        int numnewlines = 4;
        while (numnewlines > 0) {
            char c;
            do {
                c = (char)(dis.readUnsignedByte());
            } while (c != '\n');
            numnewlines--;
        }

        // read the image data
        int height =pgmStructure.getHeight();
        int width  = pgmStructure.getWidth();
        pgmStructure.setImage(new int[pgmStructure.getHeight()][pgmStructure.getWidth()]);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pgmStructure.getImage()[row][col] = dis.readUnsignedByte();
                System.out.print(pgmStructure.getImage()[row][col] + " ");
            }
            System.out.println();

        }
        pgmStructure.setPatternSize(5);
        return pgmStructure;
    }
}

