public class RightAngleTriangle extends Shape {
    private int width;
    private int height;

    RightAngleTriangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    /**
     * @return the area of the shape
     */
    public double area() {return (width * height) / 2.0;}

    /**
     * @return the perimeter of the shape
     */
    public double perimeter() {return width + height + (Math.sqrt(width * width + height * height));}

    /**
     * @return gets the width of the shape
     */
    public int getWidth() {return width;}

    /**
     * @return gets the height of the shape
     */
    public int getHeight() {return height;}

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
        String[] result = new String[height + 1];

        // Max length: 1 + (width - 1) * 3 + 2
        int totalLength = 1 + (width - 1) * 3 + 2;

        for (int i = 0; i < height; i++) {
            int stars = (int) ((double) (i + 1) * width / height);

            if (stars < 1) stars = 1; // ensure at least one star

            StringBuilder line = new StringBuilder(" ");

            for (int j = 0; j < stars; j++) {
                line.append("*");
                if (j < stars - 1) {
                    line.append("  "); // 2 spaces between stars
                } else {
                    line.append(" "); // 1 space after last star
                }
            }

            while (line.length() < totalLength) {
                line.append(" ");
            }

            result[i] = line.toString();
        }

        result[height] = ""; // empty final line
        return result;
    }





}
