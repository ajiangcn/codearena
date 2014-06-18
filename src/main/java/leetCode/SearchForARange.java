package leetCode;

public class SearchForARange {

    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (A == null || A.length == 0) {
            return result;
        }

        int base = binarySearch(A, 0, A.length-1, target);
        int lowerBound = -1;
        int upperBound = -1;
        int ltmp = base;
        int utmp = base;
        while (ltmp != -1) {
            lowerBound = ltmp;
            ltmp = binarySearch(A, 0, lowerBound-1, target);
        }
        while (utmp != -1) {
            upperBound = utmp;
            utmp = binarySearch(A, upperBound+1, A.length-1, target);
        }
        result[0] = lowerBound;
        result[1] = upperBound;
        return result;
    }

    protected int binarySearch(int[] A, int start, int end, int target) {
        int mid = start + (end - start) / 2;

        if (start == end) {
            return A[start] == target ? start : -1;
        } else if (start > end) {
            return -1;
        }
        if (A[mid] == target) {
            return mid;
        } else if (A[mid] < target) {
            return binarySearch(A, mid+1, end, target);
        } else {
            return binarySearch(A, start, mid-1, target);
        }
    }
}
