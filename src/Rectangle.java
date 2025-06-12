public class Rectangle extends Shape {
    protected int width;
    protected int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * @return the area of the shape
     */
    public double area() {
        return width * height;
    }

    /**
     * @return the perimeter of the shape
     */
    public double perimeter() {
        return 2 * (width + height);
    }

    /**
     * @return the width of the shape
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height of the shape
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param obj object could be one of the shapes
     * @return true if obj is the same shape as this
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Rectangle other) {
            return this.width == other.getWidth() && this.height == other.getHeight();
        }
        return false;
    }

    /**
     * when asked to print the shape by itself
     * @return the whole shape as a String
     */
    @Override
    public String toString() {return String.join("\n", toStringArray());}


    /**
     * draw the shape line by line
     * @return an array of Strings where every String is a line of the shape
     */
    @Override
    public String[] toStringArray() {
        String[] lines = new String[height + 1];

        for (int i = 0; i < height; i++) {
            String row = STAR.repeat(width); // line with stars
            lines[i] = row;
        }
        lines[height] = "";
        return lines;
    }
}