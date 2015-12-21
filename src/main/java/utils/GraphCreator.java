package utils;

import model.Node;
import model.PGMStructure;

import java.util.Stack;

/**
 * Created by BurakMac on 21/12/15.
 */
public class GraphCreator {

    private Node[][] data;
    private int patternSize;
    private int height, width;
    private Stack<Node> path;
    public GraphCreator(PGMStructure pgmStructure)
    {
        setPatternSize(pgmStructure.getPatternSize());
        this.width =  (pgmStructure.getWidth()/patternSize)+1;
        this.height = (pgmStructure.getHeight()/patternSize)+1;

        data = new Node[height][width];

        for(int i=0; i<height;i++)
        {
            for(int j=0; j<width;j++)
            {
                int returnedval = makeGroup(i,j,pgmStructure);
                boolean isOccupied = false;
                if(returnedval == 0)
                    isOccupied = true;
                Node node =new Node();
                node.setNumber((i*width+j));
                node.setOccupied(isOccupied);
                node.setX(i);
                node.setY(j);
                data[i][j] = node;
            }
        }
        makeRelations();
    }
    private void makeRelations()
    {
        for(int i=0; i<height; i++)
        {
            for(int j=0; j<width; j++)
            {
                if(i != height-1)
                {
                    if(data[i+1][j].isOccupied() == false)
                        data[i][j].getChildren()[2] = data[i+1][j];

                }
                if( i != 0)
                {
                    if(data[i-1][j].isOccupied() == false)
                        data[i][j].getChildren()[0] = data[i-1][j];

                }
                if(j != (width-1))
                {
                    if(data[i][j+1].isOccupied() == false)
                        data[i][j].getChildren()[1] = data[i][j+1];
                }
                if(j!=0)
                {
                    if(data[i][j-1].isOccupied() == false)
                        data[i][j].getChildren()[3] = data[i][j-1];
                }
            }
        }
    }

    private int makeGroup(int i, int j , PGMStructure pgmStructure)
    {
        for(int a= 0; a<patternSize;a++)
        {
            for(int b=0;b<patternSize;b++)
            {
                if((i*patternSize+a <pgmStructure.getHeight()) && (j*patternSize+b <pgmStructure.getWidth())) {
                    if (pgmStructure.getImage()[i * patternSize + a][j * patternSize + b] == 0) {
                        return 0;
                    }
                }
                else
                {
                    continue;
                }
            }
        }
        return 255;
    }

    public int getPatternSize() {
        return patternSize;
    }

    public void setPatternSize(int patternSize) {
        this.patternSize = patternSize;
    }
    public void print()
    {
        for(int i=0; i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                if( data[i][j].isPath())
                {
                    System.out.print("2 ");

                }
                else if(data[i][j].isOccupied())
                {
                    System.out.print("1 ");
                }
                else
                {
                    System.out.print("0 ");
                }

            }
            System.out.println();
        }
    }

    public Node[][] getData() {
        return data;
    }

    public void setData(Node[][] data) {
        this.data = data;
    }

    public Stack<Node> getPath() {
        return path;
    }

    public void setPath(Stack<Node> path) {
        this.path = path;
    }
}

