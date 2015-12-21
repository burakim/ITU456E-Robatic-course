package utils;

import model.Node;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Stack;

/**
 * Created by BurakMac on 21/12/15.
 */
public class OutputManager {
    private String filename;
    private Stack<Node> path;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Stack<Node> getPath() {
        return path;
    }

    public void setPath(Stack<Node> path) {
        this.path = path;
    }

    public void write() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer= new PrintWriter("route.txt","UTF-8");
        Node newest = null;
        Node oldest = null;
        int size1 = path.size();
        double resolution_ratio = 10.0;
        int originX = 11;
        int originY = 28;

        while(path.size()>0)
        {
            newest = path.pop();
            int newestX = newest.getX() - originX;
            int newestY = newest.getY() - originY;
            int oldestX =-1;
            int oldestY = -1;
            if(size1 != path.size()+1)
            {
                oldestX = oldest.getX() - originX;
                oldestY = oldest.getY() - originY;
            }

            double theta = Math.atan2(newestY-oldestY, newestX-oldestX);


            if(oldestX !=-1 && oldestY != -1 )
                writer.println("(" + newestX/resolution_ratio + ", "+newestY/resolution_ratio + ", " + theta + "),");
            oldest = newest;
        }
        writer.close();
    }
}