package leetCode;

public class PalindromePartitioningII {

    public int minCut(String s) {
        if(s == null || s.length()==0) {
            return 0;
        }
        String lps = findTheLongestPalindrome(s);
        if(s.equals(lps)) {
            return 0;
        }
        int index = s.indexOf(lps);
        int result = 0;
        String left = s.substring(0, index);
        String right = s.substring(index+lps.length());
        result += minCut(left);
        result += minCut(right);
        if (index==0 || index+lps.length() == (s.length())) {
            result +=1;
        } else {
            result += 2;
        }
        System.out.println(lps);
        return result;
    }

    public String findTheLongestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++) {
            sb.append('#');
            sb.append(chars[i]);
        }
        sb.append('#');

        char[] ss = sb.toString().toCharArray();
        int[] pp = new int[ss.length];

        // populate pp
        int mx = 0;
        int id = 0;
        int max = 0;
        for(int i=0; i<ss.length; i++) {
            pp[i] = mx > i ? Math.min((mx-i), pp[2*id-i]) : 1;
            while((i+pp[i])<ss.length && (i-pp[i]) >= 0 && ss[i+pp[i]] == ss[i-pp[i]]) {
                pp[i]++;
            }
            if(i + pp[i] > mx) {
                mx = i + pp[i];
                id = i;
            }
            if(pp[i] > pp[max]) {
                max = i;
            }
        }

        String rawResult = sb.toString().substring(max-(pp[max]-1), max+(pp[max]));
        String result = rawResult.replace("#","");
        return result;
    }
}
