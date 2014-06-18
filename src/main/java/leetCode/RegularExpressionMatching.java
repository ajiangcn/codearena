package leetCode;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(s == null && p == null) {
            return true;
        } else if((s == null && p != null) ||(s!=null && p==null)) {
            return false;
        }
        // pattern does not include special character
        if(p.indexOf('.') == -1 && p.indexOf('*') == -1) {
            return s.equals(p);
        }
        // include pattern .*
        if(p.equals(".*")) {
            return true;
        }

        return true;
    }
}
