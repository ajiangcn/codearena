package algorithmDesignManual.chapter6;

/**
 * Created by youjiang on 3/23/14.
 */
public class SetUnion {
    public static int SET_SIZE = 1000;

    int[] p = new int[SET_SIZE+1]; /* parent element */
    int[] size = new int[SET_SIZE+1]; /* number of elements in subtree i */
    int n; /* number of elements in set */

    SetUnion(int x) {
        n = x;
        for(int i=1; i<=n; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if(p[x] == x) {
            return x;
        } else {
            return find(p[x]);
        }
    }

    int union_sets(int s1, int s2) {
        int r1, r2; /* root of sets */
        r1 = find(s1);
        r2 = find(s2);

        if(r1 == r2) return r1; /* already in the same set */
        if(size[r1] >= size[r2]) {
            size[r1] = size[r1] + size[r2];
            p[r2] = r1;
            return r1;
        } else {
            size[r2] = size[r1] + size[r2];
            p[r1] = r2;
            return r2;
        }
    }

    boolean same_components(int s1, int s2) {
        return find(s1) == find(s2);
    }
}
