package topcoder.SRM144;

public class BinaryCode {

    private static String NONE = "NONE";

    public String[] decode(String message) {
        if(message == null) {
            return null;
        }
        String[] result = new String[2];
        result[0] = flatString(message, 0);
        result[1] = flatString(message, 1);
        return result;
    }

    private String flatString(String message, int assumption) {
        int length = message.length();
        if(length == 1) {
            if(message.charAt(0) == '0' || message.charAt(0) == '1') {
                return message;
            } else {
                return NONE;
            }
        }
        int[] Q = string2IntArray(message);
        int[] P = new int[length];
        P[0] = assumption;
        if(length > 1) {
            P[1] = Q[0] - P[0];
            if (P[1] != 1 && P[1] != 0) {
                return NONE;
            }
        }
        for(int i=2; i<length; i++) {
            P[i] = Q[i-1] - P[i-1] - P[i-2];
            if (P[i] != 1 && P[i] != 0) {
                return NONE;
            }
        }
        if (Q[length-1] != P[length-1] + P[length-2]) {
            return NONE;
        } else {
            return intArray2String(P);
        }
    }

    private int[] string2IntArray(String message) {
        int length = message.length();
        int[] result = new int[length];
        for(int i=0; i<length; i++) {
            result[i] = Character.getNumericValue(message.charAt(i));
        }
        return result;
    }

    private String intArray2String(int[] intArray) {
        char[] result = new char[intArray.length];
        for(int i=0; i<intArray.length; i++) {
            result[i] = Character.forDigit(intArray[i], 10);
        }
        return String.valueOf(result);
    }
}
