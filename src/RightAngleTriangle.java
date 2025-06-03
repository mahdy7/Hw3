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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle other)) return false;
        return this.width == other.getWidth() && this.height == other.getHeight();
    }
    @Override
    public String toString() {
        String s = "";
        for (int i = 1; i <= getHeight(); i++) {
            int stars = ((i - 1) * getWidth()) / getHeight() + 1;
            if (stars < 1) stars = 1;
            s += "* ".repeat(stars) + "\n";
        }
        return s;
    }
}
