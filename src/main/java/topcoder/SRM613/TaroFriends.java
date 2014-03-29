package topcoder.SRM613;

public class TaroFriends {

    class IntArrayStats {
        int min;
        int max;
        double avg;

        IntArrayStats(int min, int max, double avg) {
            this.min = min; this.max = max; this.avg = avg;
        }
    }

    public int getNumber(int[] coordinates, int X) {
        if(coordinates.length == 1) return 0;
        IntArrayStats stats = getIntArrayStats(coordinates);
        int[] newCoords = new int[coordinates.length];
        for(int i=0; i<coordinates.length; i++) {
            if(coordinates[i] >= stats.avg) {
                newCoords[i] = coordinates[i]-X;
            } else {
                newCoords[i] = coordinates[i]+X;
            }
        }
        IntArrayStats newStats = getIntArrayStats(newCoords);
        int od = stats.max-stats.min;
        int nd = newStats.max-newStats.min;
        return od > nd ? nd : od;
    }

    private IntArrayStats getIntArrayStats(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for(int n : nums) {
            if(n<min) min = n;
            if(n>max) max = n;
            sum += n;
        }
        //return new IntArrayStats(min, max, sum/nums.length);
        return new IntArrayStats(min, max, min + (max-min)/2d);
    }
}
