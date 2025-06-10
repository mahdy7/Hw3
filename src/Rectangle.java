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
        int lineCount = height * 2 - 1; // height + (height - 1) blank lines
        String[] lines = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
            if (i % 2 == 1) {
                lines[i] = ""; // blank line
            } else {
                String row = " * ".repeat(width); // line with stars
                lines[i] = row;
            }
        }

        return lines;
    }

    @Override
    public String toString() {
        return String.join("\n", toStringArray());
    }
}
