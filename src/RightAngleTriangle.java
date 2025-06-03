public class RightAngleTriangle extends Shape {
    private int width;
    private int height;

    RightAngleTriangle(int width,int height) {
        this.width = width;
        this.height = height;
    }

    public double area(){return (width*height)/2.0;}

    public double perimeter(){return width+height+(Math.sqrt(width*width+height*height));}

    public int getWidth() {return width;}

    public int getHeight() {return height;}
}
