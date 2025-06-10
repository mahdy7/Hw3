public class Square extends Rectangle

{
    private int sideLength;

    Square(int sideLength) {
        super(sideLength, sideLength);
    }

    public double area() {return width*width;}

    public double perimeter() {return width*4;}

    public int getWidth() {return width;}

    public int getHeight() {return width;}


    // Optional: override toString to make printing directly also look good
   /* @Override
    public String toString() {
        return String.join("\n", toStringArray());
    }*/
}
