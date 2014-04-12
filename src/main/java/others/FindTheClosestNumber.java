package others;

public class FindTheClosestNumber {

    public static int find(int[] a, int key) {
        return find(a, key, 0, a.length-1);
    }

    private static int find(int[] a, int key, int lo, int hi) {
        if(key <= a[lo]) {
            return lo;
        }

        if(key >= a[hi]) {
            return hi;
        }

        if(hi - lo == 1) {
            return (key - a[lo]) > (a[hi] - key) ? hi : lo;
        }

        int mid = lo + (hi-lo)/2;
        if(key >= a[mid]) {
            return find(a, key, mid, hi);
        } else {
            return find(a, key, lo, mid);
        }
    }

}
