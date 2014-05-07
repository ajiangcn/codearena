package leetCode;

import java.util.ArrayList;

public class NQueens {

    public ArrayList<String[]> solveNQueens(int n) {
        if (n <=3) {
            ArrayList<String[]> result =    new ArrayList<String[]>();
            if (n == 1) {
                String[] s = new String[1];
                s[0] = "Q";
                result.add(s);
            }
            return result;
        }
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] partialSolution = new int[n+1];  // column number for each row
        backTrack(partialSolution, 0, n, result);
        return result;
    }

    private void backTrack(int[] partialSolution, int k, int n, ArrayList<String[]> result) {
        // find a solution
        if (k == n) {
            String[] solution = new String[n];
            for (int i=1; i<=n; i++) {
                // StringBuffer is synchronized, but StringBuilder is not
                StringBuilder sb = new StringBuilder();
                for (int j=1; j<=n; j++) {
                    if (partialSolution[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                solution[i-1] = sb.toString();
            }
            result.add(solution);
            return;
        }

        // if there still queens need to be placed
        int[] candidatePosition = new int[n];
        int nCandidates = construct_candidates(partialSolution, k, n, candidatePosition);
        if (nCandidates == 0) {
            // no solution for the given arrangement.
            return;
        }

        for (int i=0; i<nCandidates; i++) {
            partialSolution[k+1] = candidatePosition[i];

            backTrack(partialSolution, k+1, n, result);

            partialSolution[k+1] = 0;
        }

    }

    private int construct_candidates(int[] partialSolution, int k, int n, int[] candidatePosition) {
        int[][] availability = new int[n+1][n+1]; // 0 availability -1 not available
        for (int i=1; i<=k; i++) {
            // set the availability of the board
            // set the row/column availability availability
            for (int j=1; j<=n; j++) {
                availability[i][j] = -1;
                availability[j][partialSolution[i]] = -1;
                if ((i + j)<=n && (partialSolution[i] + j) <=n ) {
                    availability[i+j][partialSolution[i]+j] = -1;
                }
                if ((i - j) >= 1 && (partialSolution[i] -j) >= 1 ) {
                    availability[i-j][partialSolution[i]-j] = -1;
                }
                if ((i + j) <= n && (partialSolution[i] - j) >= 1 ) {
                    availability[i+j][partialSolution[i]-j] = -1;
                }
                if ((i - j) >= 1 && (partialSolution[i] +j) <= n ) {
                    availability[i-j][partialSolution[i]+j] = -1;
                }
            }
        }

        int idx = 0;
        for (int i=1; i<=n; i++) {
            if (availability[k+1][i] == 0) {
                candidatePosition[idx++] = i;
            }
        }

        return idx;
    }
}
