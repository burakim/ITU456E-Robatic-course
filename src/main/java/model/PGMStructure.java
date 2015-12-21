package model;

/**
 * Created by BurakMac on 21/12/15.
 */
public class PGMStructure {
    private int[][] image;
    private int width;
    private int height;
    private int maxVal;
    private int patternSize;
    public int[][] getImage() {
        return image;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(int maxVal) {
        this.maxVal = maxVal;
    }

    public int getPatternSize() {
        return patternSize;
    }

    public void setPatternSize(int patternSize) {
        this.patternSize = patternSize;
    }
}
