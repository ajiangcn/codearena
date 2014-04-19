package others;

import java.util.Random;

public class QuickSort {

    public static <T extends Comparable> void sort(T[] input) {
        // validate the input data
        if (input == null || input.length==1) {
            return;
        }
        sort(input, 0, input.length-1);
    }

    public static <T extends Comparable> void sort(T[] input, int lower, int upper) {
        if(lower >= upper) {
            return;
        }
        int pivotIdx = lower + new Random().nextInt(upper-lower);
        int m=lower;
        int n=upper;
        while(lower < upper) {
            if(input[lower].compareTo(input[pivotIdx]) > 0) {
                swap(input, pivotIdx, lower);
                pivotIdx = lower;
            } else if (input[upper].compareTo(input[pivotIdx]) < 0) {
                swap(input, pivotIdx, upper);
                pivotIdx = upper;
            } else if (input[lower].compareTo(input[pivotIdx]) <=0 && lower < pivotIdx) {
                lower++;
            } else if(input[upper].compareTo(input[pivotIdx]) >=0 && upper > pivotIdx) {
                upper--;
            }
        }

        // sort the first half of the aray
        sort(input, m, pivotIdx-1);
        // sort the second half
        sort(input, pivotIdx+1, n);
    }

    private static <T extends Comparable> void swap(T[] input, int x, int y) {
        T temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }

}