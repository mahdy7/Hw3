public class RightAngleTriangle extends Shape {
    private int width;
    private int height;

    RightAngleTriangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return (width * height) / 2.0;
    }

    public double perimeter() {
        return width + height + (Math.sqrt(width * width + height * height));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    @Override
    public String toString() {
        return String.join("\n", toStringArray());
    }

    @Override
    public String[] toStringArray() {
        String[] result = new String[height+1];
        int maxStars = width;

        int totalLength = 1 + (maxStars - 1) * 3 + 2;

        for (int i = 0; i < height; i++) {
            int stars = (i * width) / height + 1;
            StringBuilder line = new StringBuilder(" ");

            for (int j = 0; j < stars; j++) {
                line.append("*");
                if (j < stars - 1) {
                    line.append("  "); // 2 spaces between stars
                } else {
                    line.append(" "); // 1 space after the last star
                }
            }

            // Fill with spaces to match the longest line
            while (line.length() < totalLength) {
                line.append(" ");
            }

            result[i] = line.toString();
        }
        result[height] = "";
        return result;
    }




}

