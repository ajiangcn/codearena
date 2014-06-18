package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Pow {

    public double pow(double x, int n) {
        if(x == 0) {
            return 0d;
        }

        if(n == Integer.MIN_VALUE) {
            return 1/(pow(x, Integer.MAX_VALUE) * x);
        }

        if(n < 0) {
            return 1d/pow(x, -n);
        }
        if(n == 0) {
            return 1;
        }

        if(n == 1) {
            return x;
        }
        if(n%2 == 0) {
            double tmp = pow(x, n/2);
            return tmp * tmp;
        } else {
            double tmp = pow(x, (n-1)/2);
            return x * tmp * tmp;
        }
    }

    public double powTR(double x, int n) {
        if(x == 0) {
            return 0d;
        }

        if(n < 0) {
            if(n == Integer.MIN_VALUE) {
                return 1/(pow(x, Integer.MAX_VALUE) * x);
            } else {
                return 1d/pow(x, -n);
            }
        }

        if(n == 0) {
            return 1;
        }

        Map<Integer, Double> resultCache = new HashMap<Integer, Double>();
        resultCache.put(0, 1d);
        return powTailRecursion(x, n, n, 1, resultCache);
    }

    private double powTailRecursion(double x, int accumulated, int remainingN, double result, Map<Integer, Double> resultCache) {
        if(remainingN == 0) {
            return result;
        }

        if(remainingN > accumulated) {
            resultCache.put(accumulated+accumulated, result*result);
            return powTailRecursion(x, accumulated+accumulated, remainingN-accumulated, result*result, resultCache);
        } else {
            if(resultCache.get(remainingN) != null) {
                return powTailRecursion(x, accumulated+remainingN, 0, resultCache.get(remainingN)*result, resultCache);
            } else {
                return powTailRecursion(x, accumulated+1, remainingN-1, x*result, resultCache);
            }
        }
    }
}
