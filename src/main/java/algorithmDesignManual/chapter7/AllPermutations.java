package algorithmDesignManual.chapter7;

import org.apache.commons.lang3.Validate;

import java.util.*;

public class AllPermutations {

    public List<String> getAllPermutations(String input) {
        Validate.notNull(input);
        List<String> result = new ArrayList<String>();
        Integer[] partialResult = new Integer[input.length()];

        backTrack(partialResult, 0, input.length(), input, result);

        return result;
    }

    /**
     * @param a partial result
     * @param k current position
     * @param n total characters
     */
    public void backTrack(Integer[] a, Integer k, Integer n, String input, List<String> result) {

        int numOfCandidates = n-k;
        Integer[] kthCandidates = new Integer[numOfCandidates];

        if (is_a_solution(a, k, n, result)) {
            process_candidate(a, k, n, input, result);
        } else {
            construct_candidates(a, k, n, kthCandidates);
            for (int i=0; i<numOfCandidates; i++) {
                a[k] = kthCandidates[i];
                backTrack(a, k+1, n, input, result);
                unmakeMove(a, k, n);
            }
        }
    }

    private void unmakeMove(Integer[] a, Integer k, Integer n) {
        a[k] = null;
    }

    private void construct_candidates(Integer[] a, int k, int n, Integer[] kthCandidates) {
        Set<Integer> usedIdx = new HashSet<Integer>(Arrays.asList(a));
        int idx = 0;
        for (int i=0; i<n; i++) {
            if (!usedIdx.contains(i)) {
                kthCandidates[idx++] = i;
            }
        }
    }

    /**
     * add the candidate to the result list
     */
    private void process_candidate(Integer[] a, Integer k, Integer n, String input, List<String> result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            sb.append(input.charAt(a[i]));
        }
        result.add(sb.toString());
    }

    /**
     * @return the length of candidate is equal to the length of the input string
     */
    private boolean is_a_solution(Integer[] a, Integer k, Integer n, List<String> result) {
        return k == n;
    }

}
