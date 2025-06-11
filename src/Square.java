public class Square extends Rectangle

{
    private int sideLength;

    Square(int sideLength) {
        super(sideLength, sideLength);
    }

    /**
     * @return the area of the shape
     */
    public double area() {return width*width;}

    /**
     * @return the perimeter of the shape
     */
    public double perimeter() {return width*4;}

    /**
     * @return gets the width of the shape
     */
    public int getWidth() {return width;}

    /**
     * @return gets the height of the shape
     */
    public int getHeight() {return width;}


}
