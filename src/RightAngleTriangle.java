public class RightAngleTriangle extends Shape {
    static final String STAR = "*";
    static final String SPACE = " ";
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
     * @return the width of the shape
     */
    public int getWidth() {return width;}

    /**
     * @return the height of the shape
     */
    public int getHeight() {return height;}

    /**
     * @param obj object could be one of the shapes
     * @return true if obj is the same shape as this
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof RightAngleTriangle other) {
            return other.width == this.width && other.height == this.height;
        }
        return false;
    }

    /**
     * @return the whole shape as a String
     */
    @Override
    public String toString() {return String.join("\n", toStringArray());}

    /**
     * @return the shape as an array of Strings where every String is a line of the shape
     */
    @Override
    public String[] toStringArray() {
        String[] result = new String[height + 1];

        // Max length: 1 + (width - 1) * 3 + 2
        int totalLength = 1 + (width - 1) * 3 + 2;

        for (int i = 0; i < height; i++) {
            int stars = (int) ((double) (i + 1) * width / height);

            if (stars < 1) stars = 1; // ensure at least one star

            StringBuilder line = new StringBuilder(SPACE);

            for (int j = 0; j < stars; j++) {
                line.append(STAR);
                if (j < stars - 1) {
                    line.append("  "); // 2 spaces between stars
                } else {
                    line.append(SPACE); // 1 space after last star
                }
            }

            while (line.length() < totalLength) {
                line.append(SPACE);
            }

            result[i] = line.toString();
        }

        result[height] = ""; // empty final line
        return result;
    }





}
