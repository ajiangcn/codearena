package algorithm;

public class ThreeWayStringQuicksort {

    public static void sort(String[] a) {
        sort(a, 0, a.length-1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        //three way partitioning using dth character
        if (hi <= lo) {
            return;
        }
        int lt = lo, gt = hi;
        int v = a[lo].charAt(d);
        int i = lo + 1;
        while(i <= gt) {
            int t = a[i].charAt(d);
            if(t<v) {
                exch(a, lt++, i++);
            } else if (t>v) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt-1, d);
        if(v>=0) {
            sort(a, lt, gt, d+1);
        }
        sort(a, gt+1, hi, d);
    }

    private static void exch(String[] a, int x, int y) {
        String temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
