public class Circle extends Shape{
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public double area(){return Math.PI * radius * radius;}

    public double perimeter(){return 2 * Math.PI * radius;}

    public int getWidth(){return radius;}

    public int getHeight(){return radius;}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Circle other)) return false;
        return this.radius == other.getWidth();
    }
}

