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
        for(int i = 0;i < this.width;i++) {
            for(int j = 0;j < this.height;j++) {
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
        for(int i = 0;i < this.width;i++) {
            for(int j = 0;j < this.height;j++) {
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

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
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


    @Override
    public String toString() {

        if (width == 0 || height == 0) {
            return "";
        }

        boolean allNull = true;
        for (int i = 0; i < width && allNull; i++) {
            for (int j = 0; j < height && allNull; j++) {
                if (canvas[i][j] != null) {
                    allNull = false;
                }
            }
        }
        if (allNull) return "";

        // Compute max widths per column
        int[] maxWidths = new int[width];
        for (int row = 0; row < width; row++) {
            int maxWidth = 0;
            for (int col = 0; col < height; col++) {
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
                if (canvas[row][col] != null && canvas[row][col].getHeight() > maxHeight) {
                    maxHeight = canvas[row][col].getHeight();
                }
            }
            maxHeights[row] = maxHeight;
        }

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < height; row++) {
            int height = maxHeights[row];

            // Collect all shapes lines for this row
            String[][] shapesLines = new String[width][];
            for (int col = 0; col < width; col++) {
                if (canvas[row][col] != null) {
                    shapesLines[col] = canvas[row][col].toStringArray();
                } else {
                    shapesLines[col] = new String[height];
                    for (int i = 0; i < height; i++) {
                        shapesLines[col][i] = ""; // empty lines to keep spacing
                    }
                }
            }

            // Build each line for this canvas row
            for (int lineIdx = 0; lineIdx < height; lineIdx++) {
                for (int col = 0; col < width; col++) {
                    String line = "";
                    if (lineIdx < shapesLines[col].length && shapesLines[col][lineIdx] != null) {
                        line = shapesLines[col][lineIdx];
                    }
                    if (line.trim().isEmpty()) {
                        sb.append(" ".repeat(maxWidths[col]));
                    } else {
                        sb.append(line);
                        int pad = maxWidths[col] - line.length();
                        if (pad > 0) {
                            sb.append(" ".repeat(pad));
                        }
                    }
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}