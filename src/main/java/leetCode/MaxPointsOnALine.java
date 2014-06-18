package leetCode;

/**
 * Created by youjiang on 3/17/14.
 */
public class MaxPointsOnALine {
    static class Point {
        int x;
        int y;
        Point() {x=0; y=0;}
        Point(int a, int b) {x=a; y=b;}
    }

    static class Parameters {
        int a;
        int b;
        Parameters(int p1, int p2) {a=p1; b=p2;}
    }

    public int maxPoints(Point[] points) {
        int numPoints = points.length;
        return 5;
    }

}
