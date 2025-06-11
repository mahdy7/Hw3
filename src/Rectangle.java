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
     * @return gets the width of the shape
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return gets the height of the shape
     */
    public int getHeight() {
        return height;
    }

    /**
     * when asked to print the shape by itself
     * @return the whole shape
     */
    @Override
    public String toString() {return String.join("\n", toStringArray());}


    /**
     * draw the shape line by line
     * @return each time the line of the shape
     */
    @Override
    public String[] toStringArray() {
        String[] lines = new String[height + 1];

        for (int i = 0; i < height; i++) {
            String row = " * ".repeat(width); // line with stars
            lines[i] = row;
        }
        lines[height] = "";
        return lines;
    }
}