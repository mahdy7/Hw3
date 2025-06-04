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

    @Override
    public String toString() {
        String line = "";
        for(int i = 0; i < radius*2 + 1; i++){
            for(int j = 0; j < radius*2 + 1; j++){
                double distance = Math.sqrt((i - (double)radius)*(i - (double)radius)+ (j - (double)radius)*(j - (double)radius));
                if(distance <= (radius + 0.3)) {
                    line += " * ";
                } else {line += "   ";}
            }
            line += "\n";
        }
        return line;
    }
}

