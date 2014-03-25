package leetCode;

/**
 * Created by youjiang on 3/17/14.
 */
public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int A[], int B[]) {

        int aIdx = 0;
        int bIdx = 0;
        int[] mergedData = new int[A.length+B.length];
        int idx = 0;
        while(aIdx < A.length && bIdx < B.length) {
            if(A[aIdx] < B[bIdx]) {
                mergedData[idx++] = A[aIdx++];
            } else {
                mergedData[idx++] = B[bIdx++];
            }
        }
        while(aIdx < A.length) {
             mergedData[idx++] = A[aIdx++];
        }
        while(bIdx < B.length) {
            mergedData[idx++] = B[bIdx++];
        }
        int median = mergedData.length/2;
        if(mergedData.length%2 == 0) {
            return Double.valueOf(mergedData[median-1] + mergedData[median]).doubleValue()/2;
        } else {
            return Double.valueOf(mergedData[median]).doubleValue();
        }
    }
}
