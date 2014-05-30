package algorithm.dp;

public class CoinChange {

    public int numOfWays(int N, int[] S) {
        int sLen = S.length;
        int[][] M = new int[N+1][sLen+1];

        for (int i=0; i<=sLen; i++) {
            M[0][i] = 1;
        }

        for (int i=1; i<=N; i++) {
            M[i][0] = 0;
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=sLen; j++) {
                int result = M[i][j-1];  // number of way to make changes with S-1 items
                result += (i-S[j-1]) >= 0 ? M[i-S[j-1]][j] : 0;
                M[i][j] = result;
            }
        }
        return M[N][sLen];
    }
}
