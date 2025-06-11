abstract class Shape {
    public abstract double area();

    public abstract double perimeter();

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract String[] toStringArray();

    @Override
    public String toString() {
        return String.join("\n", toStringArray());
    }

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
