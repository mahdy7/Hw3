abstract class Shape {
    public abstract double area();

    public abstract double perimeter();

    public abstract int getWidth();

    public abstract int getHeight();

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.equals((other));
    }
}
