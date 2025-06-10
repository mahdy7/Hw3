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
        int size = radius*2 + 1;
        String[] lines = new String[size+1];

        for (int i = 0; i < size; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < size; j++) {
                    double dx = i - radius;
                    double dy = j - radius;
                    double dist = Math.sqrt(dx * dx + dy * dy);
                    if (dist <= radius + 0.3) {
                        line.append(" * ");
                    } else {
                        line.append("   ");
                    }
                }
                lines[i] = line.toString();
        }
        lines[size] = "";
        return lines;
    }
}
