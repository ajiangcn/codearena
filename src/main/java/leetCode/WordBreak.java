package leetCode;

import java.util.*;

public class WordBreak {

    // dynamic programming
    public boolean wordBreak(String s, Set<String> dict) {
        int wlen = s.length();

        // array indicate whether the substring(0, i) is breakable
        boolean[] T = new boolean[wlen+1];
        T[0] = true;
        for(int i=0; i<=wlen; i++) {
            if(!T[i]) {
                continue;
            }

            for (String w : dict) {
                int len = w.length();
                int endIdx = i + len;
                if (endIdx > s.length()) {
                    continue;
                }

                String tmp = s.substring(i, endIdx);
                if (dict.contains(tmp)) {
                    T[endIdx] = true;
                }
            }
        }
        return T[s.length()];
    }

    /**
     * DP for word break II
     */
    public ArrayList<String> wordBreakII(String s, Set<String> dict) {
        int wlen = s.length();

        // array indicate whether the substring(0, i) is breakable
        List<List<Integer>> T = new ArrayList<List<Integer>>(s.length()+1);
        for (int i=0; i<=s.length(); i++) {
            T.add(i, new ArrayList<Integer>());
        }
        List<Integer> zeroIdx= new ArrayList<Integer>();
        zeroIdx.add(0);
        T.set(0, zeroIdx);

        for(int i=0; i<=wlen; i++) {
            if(T.get(i).size() == 0) {
                continue;
            }

            for (String w : dict) {
                int len = w.length();
                int endIdx = i + len;
                if (endIdx > s.length()) {
                    continue;
                }

                String tmp = s.substring(i, endIdx);
                if (tmp.equals(w)) {
                        T.get(endIdx).add(i);
                }
            }
        }

        List<String> stack = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        wordBreakIIHelper(s, s.length(), T, stack, result);
        return result;
    }

    public void wordBreakIIHelper(String s, int idx, List<List<Integer>> indexes, List<String> solution, List<String> result) {

        if (idx == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i=solution.size()-1; i>=0; i--) {
                sb.append(solution.get(i) + " ");
            }
            result.add(sb.toString().trim());
        } else {
            for (int i=0; i<indexes.get(idx).size(); i++) {
                int startIdx = indexes.get(idx).get(i);
                solution.add(s.substring(startIdx, idx));
                wordBreakIIHelper(s, startIdx,indexes,solution,result);
                solution.remove(solution.size()-1);
            }
        }
    }

    public ArrayList<String> wordBreakIINaive(String s, Set<String> dict) {
        int max = 0;
        Set<String> jSet = new HashSet<String>();
        for (String str : dict) {
            jSet.add(str);
            if (str.length() > max) {
                max = str.length();
            }
        }
        Map<String, Boolean> subSolution = new HashMap<String, Boolean>();
        List<String> start = new ArrayList<String>();
        List<String> end = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        checkWordBreak(s, jSet, max, subSolution, start, end, result);
        return result;
    }

    // naive method
    public boolean wordBreakNaive(String s, Set<String> dict) {
        int max = 0;
        Set<String> jSet = new HashSet<String>();
        for (String str : dict) {
            jSet.add(str);
            if (str.length() > max) {
                max = str.length();
            }
        }
        Map<String, Boolean> subSolution = new HashMap<String, Boolean>();
        List<String> start = new ArrayList<String>();
        List<String> end = new ArrayList<String>();
        List<String> result = new ArrayList<String>();

        return checkWordBreak(s, jSet, max, subSolution, start, end, result);
    }

    protected boolean checkWordBreak(String s, Set<String> dict, int max, Map<String, Boolean> solutions, List<String> start, List<String> end, List<String> result) {
        if (s == null || s.length() == 0 || dict.contains(s)) {
            if(s.length() > 0) {start.add(s);};
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<start.size(); i++) {
                sb.append(start.get(i) + " ");
            }
            for (int i=end.size()-1; i>=0; i--) {
                sb.append(end.get(i) + " ");
            }
            result.add(sb.toString().trim());
            if (s.length() > 0) {start.remove(start.size()-1);};

            if (s.length() > 0) {
                dict.remove(s);
                checkWordBreak(s, dict, max, solutions, start, end, result);
                dict.add(s);
            }
            return true;
        }

        int len = max > s.length() ? s.length() : max;
        boolean res = false;
        for (int i=len; i>0;i--) {
            String tmp = s.substring(0, i);
            if (dict.contains(tmp)) {
                start.add(tmp);
                for (int j=1; j<=(s.length()-i); j++) {
                    String tmp2 = s.substring(s.length()-j);
                    if (dict.contains(tmp2)) {
                        end.add(tmp2);
                        boolean tmpRes = checkWordBreak(s.substring(i,s.length()-j), dict, max, solutions, start, end, result);
                        if(tmpRes==true) {res = true;}
                        end.remove(end.size()-1);
                    }
                }
                start.remove(start.size()-1);
            }
        }
        return res;
    }
}
