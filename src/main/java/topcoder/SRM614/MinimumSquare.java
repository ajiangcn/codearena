package topcoder.SRM614;

public class MinimumSquare {

    public long minArea(int[] x, int[] y, int K) {
        // find left most point
        int idxLeft = -1;
        int leftMost = Integer.MAX_VALUE;
        int idxRight = -1;
        int rightMost = Integer.MIN_VALUE;
        int idxUp = -1;
        int upMost = Integer.MIN_VALUE;
        int idxDown = -1;
        int downMost = Integer.MAX_VALUE;
        for(int i=0; i<x.length; i++) {
            if(x[i] < leftMost) {
                leftMost = x[i];
                idxLeft = i;
            }
            if(x[i] > rightMost) {
                rightMost = x[i];
                idxRight = i;
            }
        }

        for(int i=0; i<y.length; i++) {
            if(y[i] < upMost) {
                upMost = y[i];
                idxUp = i;
            }
            if(y[i] > downMost) {
                downMost = x[i];
                idxDown = i;
            }
        }


        // find right most point
        return 1l;
    }
}
