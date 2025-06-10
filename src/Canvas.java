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
        for(int i = 0;i < this.canRow();i++) {
            for(int j = 0;j < this.canCol();j++) {
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

        if (this.canRow() != otherCanvas.canRow() || this.canCol() != otherCanvas.canCol()) {
            return false;
        }

        for (int i = 0; i < this.canRow(); i++) {
            for (int j = 0; j < this.canCol(); j++) {
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


    /**
     * the function get max width from the shape with the max width to print all the nulls
     * @return the max width
     */
    // Returns the maximum width of all shapes in the canvas
    private int getMaxShapeWidth() {
        int maxWidth = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] != null) {
                    maxWidth = Math.max(maxWidth, canvas[i][j].getWidth());
                }
            }
        }
        return maxWidth * 3; // 2 spaces between * and 1 trailing space
    }


    private int getRowMaxHeight(int row) {
        int maxHeight = 0;
        for (int j = 0; j < canvas[0].length; j++) {
            if (canvas[row][j] != null) {
                maxHeight = Math.max(maxHeight, canvas[row][j].getHeight());
            }
        }
        return maxHeight;
    }


    @Override
    public String toString() {
        int rows = canRow();
        int cols = canCol();

        if (rows == 0 || cols == 0) {
            return "";
        }


        boolean allNull = true;
        for (int i = 0; i < rows && allNull; i++) {
            for (int j = 0; j < cols && allNull; j++) {
                if (canvas[i][j] != null) {
                    allNull = false;
                }
            }
        }
        if (allNull) {
            return "";
        }

        // Compute max widths per column
        int[] maxWidths = new int[cols];
        for (int col = 0; col < cols; col++) {
            int maxWidth = 0;
            for (int row = 0; row < rows; row++) {
                if (canvas[row][col] != null) {
                    String[] lines = canvas[row][col].toStringArray();
                    for (String line : lines) {
                        if (line.length() > maxWidth) {
                            maxWidth = line.length();
                        }
                    }
                }
            }
            maxWidths[col] = maxWidth > 0 ? maxWidth : 1;
        }

        // Compute max heights per row
        int[] maxHeights = new int[rows];
        for (int row = 0; row < rows; row++) {
            int maxHeight = 0;
            for (int col = 0; col < cols; col++) {
                if (canvas[row][col] != null) {
                    int h = canvas[row][col].toStringArray().length;
                    if (h > maxHeight) {
                        maxHeight = h;
                    }
                }
            }
            maxHeights[row] = maxHeight > 0 ? maxHeight : 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < rows; row++) {
            int height = maxHeights[row];

            // Collect all shapes lines for this row
            String[][] shapesLines = new String[cols][];
            for (int col = 0; col < cols; col++) {
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
                for (int col = 0; col < cols; col++) {
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