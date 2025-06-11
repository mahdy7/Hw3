public class Canvas {

    private Shape[][] canvas;
    private int width;
    private int height;

    Canvas(int height, int width) {
    this.canvas = new Shape[height][width];
    this.height = height;
    this.width = width;
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
        for(int i = 0;i < this.height;i++) {
            for(int j = 0;j < this.width;j++) {
                if (this.canvas[i][j] == null) {continue;}
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
        for(int i = 0;i < this.height;i++) {
            for(int j = 0;j < this.width;j++) {
                if (this.canvas[i][j] == null) {continue;}
                sum += this.canvas[i][j].perimeter();
            }
        }
        return sum;
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Canvas otherCanvas)) {
            return false;
        }

        if (this.width != otherCanvas.width || this.height != otherCanvas.height) {
            return false;
        }

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Shape a = this.canvas[i][j];
                Shape b = otherCanvas.canvas[i][j];

                if (a == null && b == null) continue;

                if (a == null || b == null || !a.equals(b)) {
                    return false;
                }
            }
        }

        return true;
    }

    public String addEmptyString(int Width) {
        return "   ".repeat(Width);
    }

    public boolean isRowNull(int row) {
        boolean isNull = true;
        for (int i = 0; i < this.width; i++) {
            if ()
        }
        return isNull;
    }

    @Override
    public String toString() {

        if (width == 0 || height == 0) {
            return "";
        }

        boolean allNull = true;
        for (int i = 0; i < height && allNull; i++) {
            for (int j = 0; j < width && allNull; j++) {
                if (canvas[i][j] != null) {
                    allNull = false;
                }
            }
        }
        if (allNull) return "";

        // Compute max widths per column
        int maxWidth = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (canvas[row][col] != null && maxWidth < canvas[row][col].getWidth()) {
                    maxWidth = canvas[row][col].getWidth();
                }
            }
        }

        // Compute max heights per row
        int[] maxHeights = new int[height];
        for (int row = 0; row < height; row++) {
            int maxHeight = 0;
            for (int col = 0; col < width; col++) {
                if (canvas[row][col] != null){
                    int currentHeight = canvas[row][col].getHeight();
                    if (currentHeight > maxHeight) {
                    maxHeight = canvas[row][col].getHeight();
                    }
                }
            }
            maxHeights[row] = maxHeight;
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < height; row++) {
            int rowHeight = maxHeights[row];
            for (int lineIdx = 0; lineIdx < rowHeight ; lineIdx++) {
                for (int shapeIdx = 0; shapeIdx < width; shapeIdx++) {
                    if (canvas[row][shapeIdx] == null) {
                        sb.append(addEmptyString(maxWidth));
                    } else if (canvas[row][shapeIdx] != null && canvas[row][shapeIdx].getHeight() < rowHeight) {
                        sb.append(addEmptyString(canvas[row][shapeIdx].getWidth()));
                    } else {
                        sb.append(canvas[row][shapeIdx].toStringArray()[lineIdx]);
                    }
                    if (shapeIdx+1 < width) sb.append("   ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}