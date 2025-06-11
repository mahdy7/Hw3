public abstract class Shape {

    /**
     *
     * @return area of the shape
     */
    public abstract double area();

    /**
     *
     * @return perimeter of the shape
     */
    public abstract double perimeter();

    /**
     *
     * @return the width of the shape
     */
    public abstract int getWidth();

    /**
     *
     * @return the height of the shape
     */
    public abstract int getHeight();

    /**
     *
     * @return to print the whole shape, by adding all the lines of she shapes together
     */
    public abstract String[] toStringArray();

    /**
     *
     * @return printing each shape line after line
     */
    @Override
    public String toString() {
        return String.join("\n", toStringArray());
    }

    /**
     *
     * @param obj object could be one of the shapes
     * @return if the two shapes are equal return ture, else false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Shape other = (Shape) obj;
        return this.getWidth() == other.getWidth() &&
                this.getHeight() == other.getHeight() &&
                Double.compare(this.area(), other.area()) == 0 &&
                Double.compare(this.perimeter(), other.perimeter()) == 0;
    }
}
