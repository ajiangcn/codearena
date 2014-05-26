package algorithm.dp;

public class LongestIncreasingSubsequence {

    public int lis(int[] nums) {
        int len = nums.length;
        int[] lens = new int[len];

        lens[0] = 1;
        int longestIdx = 0;
        for(int i=1; i<len; i++) {
            if (nums[i] > nums[longestIdx]) {
                lens[i] = lens[longestIdx] + 1;
                longestIdx = i;
            } else {
                int j = i - 1;
                while (j>=0 && lens[i] < lens[j]) {
                    j--;
                }
                if (j==-1) {
                    lens[i] = 1;
                } else {
                    lens[i] = lens[j] + 1;
                    if (lens[i] > lens[longestIdx]) {
                        longestIdx = i;
                    }
                }
            }
        }
        return lens[len-1];
    }
}
