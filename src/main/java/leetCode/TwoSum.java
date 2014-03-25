package leetCode;

/**
 * Created by youjiang on 3/17/14.
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {

        int[] numbersCopy = new int[numbers.length];
        System.arraycopy(numbers, 0, numbersCopy, 0, numbers.length);

        // sort the numbers using quick sort
        quickSort(numbersCopy, 0, numbersCopy.length-1);

        int[] result = new int[2];

        // for each number[i], binary search of the target-numbers[i]
        // if the result is found, return the index, otherwise continue the loop
        for(int i=0; i<numbersCopy.length-1; i++){
            int a = numbersCopy[i];
            int b = target - a;
            if(binarySearch(numbersCopy, i+1, b)) {
                int idx1 = getIndex(numbers, -1, a) + 1;
                int idx2 = getIndex(numbers, idx1-1, b)+1;
                if(idx1 > idx2) {
                    result[0] = idx2;
                    result[1] = idx1;
                } else {
                    result[0] = idx1;
                    result[1] = idx2;
                }
            }
        }
        return result;
    }

    int getIndex(int[] numbers, int idx, int b) {
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == b && i != idx) {
                return i;
            }
        }
        return -1;
    }
    boolean binarySearch(int[] numbers, int startIdx, int b) {
        if(numbers[startIdx] > b) {
            return false;
        }

        if(numbers[numbers.length-1] < b) {
            return false;
        }

        int lower = startIdx;
        int upper = numbers.length-1;
        int mid = -1;
        while(upper - lower > 1) {
            mid = lower + (upper-lower)/2;
            if(numbers[mid] == b) {
                return true;
            } else if(numbers[mid] > b){
                upper = mid;
            } else if(numbers[mid] < b) {
                lower = mid;
            }
        }
        if (numbers[lower] == b) {
            return true;
        }
        if (numbers[upper] == b) {
           return true;
        }

        return false;
    }
    /**
     * Sort the numbers in ascending order
     * @param numbers
     * @param left
     * @param right
     * @return in place sorted array
     */
    int[] quickSort(int[] numbers, int left, int right) {
        if(right-left < 1) return numbers;
        int pivotIndex = left + (right-left)/2;
        int pivotValue = numbers[pivotIndex];
        int storeIndex = left;

        int temp = numbers[right];
        numbers[right] = pivotValue;
        numbers[pivotIndex] = temp;
        for(int i=left; i<=right-1; i++) {
            if(numbers[i] <= pivotValue) {
                temp = numbers[i];
                numbers[i] = numbers[storeIndex];
                numbers[storeIndex] = temp;
                storeIndex++;
            }
        }

        temp = numbers[right];
        numbers[right] = numbers[storeIndex];
        numbers[storeIndex] = temp;

        if(storeIndex > left) {
            quickSort(numbers, left, storeIndex-1);
        }
        if(storeIndex < right) {
            quickSort(numbers, storeIndex+1, right);
        }
        return numbers;
    }
}
