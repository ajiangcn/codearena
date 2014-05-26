package leetCode;

import java.util.ArrayList;

public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int length = num.length;
        int[] sortedNum = new int[length];
        System.arraycopy(num, 0, sortedNum, 0, length);

        for (int i=0; i<(length-2); i++) {
            for (int j=(length-1); j>1; j--) {
                int twoSum = sortedNum[i] + sortedNum[j];


            }
        }
        return null;
    }

    protected boolean twoSumHelper(int[] sortedNum, int target) {
        return false;
    }
}
