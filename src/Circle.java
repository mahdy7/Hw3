public class Circle extends Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    /**
     * @return the radius of the circle
     */
    public int getRadius() {return radius;}

    /**
     * @return the area of the shape
     */
    public double area() {return Math.PI * radius * radius;}

    /**
     * @return the perimeter of the shape
     */
    public double perimeter() {return 2 * Math.PI * radius;}

    /**
     * @return the width of the shape
     */
    public int getWidth() {return radius*2+1;}

    /**
     * @return the height of the shape
     */
    public int getHeight() {return radius*2+1;}

    /**
     * @param object object could be one of the shapes
     * @return true if obj is the same shape as this
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof Circle other) {
            return other.getRadius() == this.radius;
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
        int size = radius*2 + 1;
        String[] lines = new String[size+1];

        for (int i = 0; i < size; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < size; j++) {
                    double dx = i - radius;
                    double dy = j - radius;
                    double dist = Math.sqrt(dx * dx + dy * dy);
                    if (dist <= radius + 0.3) {
                        line.append(STAR);
                    } else {
                        line.append(SPACE);
                    }
                }
                lines[i] = line.toString();
        }
        lines[size] = "";
        return lines;
    }
}
