public class Canvas {

    private Shape[][] canvas;
    private int width;
    private int height;

    Canvas(int width, int height) {
    this.canvas = new Shape[width][height];
    this.width = width;
    this.height = height;
}
    private int canRow() {
        return this.width;
    }
    private int canCol() {
        return this.height;
    }
    /**
     * the function gets shape, row and column and add the shape to the array
     * @param shape the shape we want to add
     * @param row the row of the shape new place
     * @param col the column of the shape new place
     */
    public void addShape(Shape shape, int row, int col) {
    this.canvas[row][col] = shape;
}

    /**
     * the function remove the shape and replace it with null
     * @param row the row of the shape we want to remove
     * @param col the column of the shape we want to remove
     */
    public void removeShape(int row, int col) {
         this.canvas[row][col] = null;
}

    /**
     * the function calculate the total area of all the shapes
     * @return the sum of all the shapes areas
     */
    public double getTotalArea() {
        double sum = 0;
        for(int i = 0;i < this.canRow();i++) {
            for(int j = 0;j < this.canCol();j++) {
                sum += this.canvas[i][j].area();
            }
        }
        return sum;
    }

    /**
     * the function calculate the total perimeter of all the shapes
     * @return the sum of all the shapes perimeters
     */
    public double getTotalPerimeter() {
        double sum = 0;
        for(int i = 0;i < this.canRow();i++) {
            for(int j = 0;j < this.canCol();j++) {
                sum += this.canvas[i][j].perimeter();
            }
        }
        return sum;
    }
    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Canvas)){
            return false;
        }
        for(int i = 0;i < this.canRow();i++) {
            for (int j = 0; j < this.canCol(); j++) {
                if (!(this.canvas[i][j].equals(((Canvas) other).canvas[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.canCol(); i++) {
            for (int j = 0; j < this.canRow(); j++) {
                s += canvas[i][j].toString() + "\n";  // call each shape's toString()
                s += "\n";  // extra blank line between shapes
            }
        }
        return s;
    }
}
