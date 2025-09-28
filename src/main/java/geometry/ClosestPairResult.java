package geometry;

public class ClosestPairResult {
    public final Point p1;
    public final Point p2;
    public final double dist;

    public ClosestPairResult(Point p1, Point p2, double dist) {
        this.p1 = p1;
        this.p2 = p2;
        this.dist = dist;
    }
}

