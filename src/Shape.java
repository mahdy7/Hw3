public abstract class Shape {
    static final String STAR = " * ";
    static final String SPACE = "   ";
    /**
     * @return area of the shape
     */
    public abstract double area();

    /**
     * @return perimeter of the shape
     */
    public abstract double perimeter();

    /**
     * @return the width of the shape
     */
    public abstract int getWidth();

    /**
     * @return the height of the shape
     */
    public abstract int getHeight();

    /**
     * @return the whole shape as an array of Strings where every String is a line of the shape
     */
    public abstract String[] toStringArray();

    /**
     * @return the shape as one String
     */
    @Override
    public String toString() {
        return String.join("\n", toStringArray());
    }

    /**
     * @param obj object could be one of the shapes
     * @return if the two shapes are equal return ture, else false
     */
    @Override
    public abstract boolean equals(Object obj);
}
