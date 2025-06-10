public class Circle extends Shape {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public int getWidth() {
        return radius;
    }

    public int getHeight() {
        return radius;
    }


    @Override
    public String toString() {
        return String.join("\n", toStringArray());
    }

    @Override
    public String[] toStringArray() {
        int size = radius * 2 + 1;
        int lineCount = size ;
        String[] lines = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
                int row = i / 2;
                StringBuilder line = new StringBuilder();
                for (int col = 0; col < size; col++) {
                    double dx = row - radius;
                    double dy = col - radius;
                    double dist = Math.sqrt(dx * dx + dy * dy);
                    if (dist <= radius + 0.3) {
                        line.append(" * ");
                    } else {
                        line.append("   ");
                    }
                }
                lines[i] = line.toString();
        }
        return lines;
    }
}
