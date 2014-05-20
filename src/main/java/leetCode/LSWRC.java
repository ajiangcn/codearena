package leetCode;

import java.util.HashSet;
import java.util.Set;

public class LSWRC {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {return 0;}
        if (s.length() == 1) {return 1;}

        Set<String> ucs = new HashSet<String>();
        int maxLen = 0;
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            String tmp = s.substring(i, i+1);
            if (ucs.contains(tmp)) {
                if(maxLen < ucs.size()) {
                    maxLen = ucs.size();
                }

                int ns = s.indexOf(tmp, start) + 1;
                if ((i-ns) > (ns-start)) {
                    for(int j=start; j<ns-1; j++) {
                         ucs.remove(s.substring(j, j+1));
                         ucs.add(tmp);
                    }
                } else {
                    ucs.clear();
                    for (int j=ns; j<=i; j++) {
                        ucs.add(s.substring(j, j+1));
                    }
                }
                start = ns;

            } else {
                ucs.add(s.substring(i, i+1));
            }

        }

        return maxLen;
    }
}
