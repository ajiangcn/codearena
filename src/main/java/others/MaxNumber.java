package others;


public class MaxNumber {

    public static int maxNumber(int N) {
        if(N<1 || N>Integer.MAX_VALUE) throw new RuntimeException("Invalid input.");
        int[] digits = new int[10];
        for(int i=0; i<digits.length; i++) {
            // initialize the digits array to -1
            digits[i] = -1;
        }

        // int 123 will be 3,2,1 in the digits array
        int remaining = N;
        int idx = 0;
        while(remaining > 0) {
            digits[idx] = remaining % 10;
            remaining /= 10;
            idx++;
        }
        // find the max digit in the digits array
        int maxIdx = -1;
        int max = -1;
        int lastIdx = -1;
        for(int i=0; i<10; i++) {
            if(digits[i] == -1) {
                lastIdx = i-1;
                break;
            }
            if(digits[i] > max) {
                max = digits[i];
                maxIdx = i;
            }
            lastIdx = i;
        }

        // swap the last idx with the max idx
        if(digits[lastIdx] < digits[maxIdx]) {
            int tmp = digits[lastIdx];
            digits[lastIdx] = digits[maxIdx];
            digits[maxIdx] = tmp;
        }

        //reconstruct the number
        int result = 0;
        for(int i=lastIdx; i>=0; i--) {
            result = (result * 10 + digits[i]);
        }
        return result;
    }
}
