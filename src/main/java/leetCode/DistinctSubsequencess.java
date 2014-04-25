package leetCode;

public class DistinctSubsequencess {

    public int numDistinct(String S, String T) {
        if (S.equals(T)) {
           return 1;
        }
        if (S.length() < T.length()) {
            return 0;
        }
        char firstT = T.charAt(0);
        int indexS = S.indexOf(firstT);
        if (indexS < 0) {
            return 0;
        }
        if (indexS == S.length() - 1) {
            return S.equals(T) ? 1 : 0;
        }

        if (T.length() == 1) {
            return 1 + numDistinct(S.substring(indexS+1), T);
        } else {
            return numDistinct(S.substring(indexS+1), T)
                    + numDistinct(S.substring(indexS+1), T.substring(1));
        }
    }
}
