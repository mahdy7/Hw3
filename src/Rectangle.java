public class Rectangle extends Shape {
    private int width;
    private int height;
    Rectangle(int width,int height) {
        this.width = width;
        this.height = height;
    }

    public double area(){return width*height;}

    public double perimeter(){return 2*(width+height);}

    public int getWidth() {return width;}

    public int getHeight() {return height;}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle other)) return false;
        return this.width == other.getWidth() && this.height == other.getHeight();
    }

    @Override
    public String toString() {
        String line = " ";
        for (int j = 0;j < width;j++) {
            line += "* ";
        }
        line += "\n";
        line = line.repeat(height);
        return line;
    }
}
