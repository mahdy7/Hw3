public class Canvas {
    final static String STAR = " * ";
    final static String SPACE = "   ";

    private Shape[][] canvas;
    private int width;
    private int height;

    Canvas(int height, int width) {
        this.canvas = new Shape[height][width];
        this.height = height;
        this.width = width;
    }

    /**
     * adds the shape to the canvas in the row and col given
     *
     * @param shape the shape we want to add
     * @param row   the row of the shape new place
     * @param col   the column of the shape new place
     */
    public void addShape(Shape shape, int row, int col) {
        this.canvas[row][col] = shape;
    }

    /**
     * removes the shape and replace it with null
     *
     * @param row the row of the shape we want to remove
     * @param col the column of the shape we want to remove
     */
    public void removeShape(int row, int col) {
        this.canvas[row][col] = null;
    }

    /**
     * calculates the total area of all the shapes
     *
     * @return the sum of all the shapes' areas
     */
    public double getTotalArea() {
        double sum = 0;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.canvas[i][j] == null) {
                    continue;
                }
                sum += this.canvas[i][j].area();
            }
        }
        return sum;
    }

    /**
     * calculates the total perimeter of all the shapes
     *
     * @return the sum of all the shapes' perimeters
     */
    public double getTotalPerimeter() {
        double sum = 0;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.canvas[i][j] == null) {
                    continue;
                }
                sum += this.canvas[i][j].perimeter();
            }
        }
        return sum;
    }

    /**
     * @param other the other canvas
     * @return if the two canvases are equal returns true, else false
     */
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

                if (a != null) {
                    if (!a.equals(b)) return false;
                } else if (b != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param Width the width of the shape
     * @return empty string with the width of the shape multiplied by 3 in spaces
     */
    public String addEmptyString(int Width) {
        return SPACE.repeat(Width);
    }

    /**
     *
     * @param row the row of the canvas as array
     * @return if the row is all null, return true, else return false
     */
    public boolean isRowNull(int row) {
        for (int i = 0; i < this.width; i++) {
            if (this.canvas[row][i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return an array with the maximum heights for each row
     */
    public int[] getMaxHeight() {

        // Compute max heights per row
        int[] maxHeights = new int[height];
        for (
                int row = 0;
                row < height; row++) {
            int maxHeight = 0;
            for (int col = 0; col < width; col++) {
                if (canvas[row][col] != null) {
                    int currentHeight = canvas[row][col].getHeight();
                    if (currentHeight > maxHeight) {
                        maxHeight = canvas[row][col].getHeight();
                    }
                }
            }
            maxHeights[row] = maxHeight;
        }
        return maxHeights;
    }

    /**
     *
     * @return the maximum width of all shapes
     */
    public int getMaxWidth() {
        int maxWidth = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (canvas[row][col] != null && maxWidth < canvas[row][col].getWidth()) {
                    maxWidth = canvas[row][col].getWidth();
                }
            }
        }
        return maxWidth;
    }

    /**
     *
     * @return return the canvas with all the shapes in it, calculating all the spaces and shapes
     */
    @Override
    public String toString() {

        if (width == 0 || height == 0) {
            return "";
        }

        int[] maxHeights = getMaxHeight();
        int maxWidth = getMaxWidth();

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < height; row++) {
            if (isRowNull(row)) {sb.append("\n");continue;}
            int rowHeight = maxHeights[row];
            for (int lineIdx = 0; lineIdx < rowHeight; lineIdx++) {
                for (int shapeIdx = 0; shapeIdx < width; shapeIdx++) {
                    if (canvas[row][shapeIdx] == null) {
                        sb.append(addEmptyString(maxWidth));
                    } else if (canvas[row][shapeIdx] != null && canvas[row][shapeIdx].getHeight() < lineIdx + 1) {
                        sb.append(addEmptyString(canvas[row][shapeIdx].getWidth()));
                    } else {
                        sb.append(canvas[row][shapeIdx].toStringArray()[lineIdx]);
                    }
                    if (shapeIdx + 1 < width) sb.append(SPACE);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}