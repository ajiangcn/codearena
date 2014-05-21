package leetCode;

import java.util.*;

public class WordBreak {

    public ArrayList<String> wordBreakII(String s, Set<String> dict) {
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

    public boolean wordBreak(String s, Set<String> dict) {
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
