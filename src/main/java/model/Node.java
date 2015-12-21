package model;

/**
 * Created by BurakMac on 21/12/15.
 */
public class Node {

    private int number;
    private int x;
    private  int y;
    private Node[] children;
    private boolean isOccupied;
    private int cost;
    private boolean isPath;

    public Node(){
        children = new Node[4];
        isPath =false;
    }
    public boolean setChildren(Node node, int index)
    {
        if(index>0 && index<4)
        {
            children[index] = node;
            return true;

        }
        else
        {
            return false;
        }
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isChild(Node childCandidate)
    {
        for(int i=0;i<children.length;i++)
        {
            if(children[i] == childCandidate)
                return true;
        }

        return false;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPath() {
        return isPath;
    }

    public void setPath(boolean path) {
        isPath = path;
    }
}
