public class Square extends Shape {
    private int sideLength;

    Square(int sideLength) {
        this.sideLength = sideLength;
    }

    public double area() {return sideLength*sideLength;}

    public double perimeter() {return sideLength*4;}

    public int getWidth() {return sideLength;}

    public int getHeight() {return sideLength;}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Square other)) return false;
        return this.sideLength == other.getWidth();
    }
}
