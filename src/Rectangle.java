public class Rectangle extends Shape {
    protected  int width;
    protected  int height;

    Rectangle(int width,int height) {
        this.width = width;
        this.height = height;
    }

    public double area(){return width*height;}

    public double perimeter(){return 2*(width+height);}

    public int getWidth() {return width;}

    public int getHeight() {return height;}


    @Override
    public String[] toStringArray() {
        String[] lines = new String[height+1];

        for (int i = 0; i < height; i++) {
                String row = " * ".repeat(width); // line with stars
                lines[i] = row;
        }
        lines[height] = "";
        return lines;
    }


    @Override
    public String toString() {
        return String.join("\n", toStringArray());
    }
}