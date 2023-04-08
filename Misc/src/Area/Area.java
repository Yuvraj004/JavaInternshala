package Area;
public class  Area {
    double length,breadth,side;
    public double Circle(double r) {
        return Math.PI*r*r;
    }
    public double Square(double s) {
        this.side = s;
        return side*side;
    }
    public double Rectangle(double l,double b) {
        this.breadth=b;this.length=l;
        return (breadth*length);
    }
}

