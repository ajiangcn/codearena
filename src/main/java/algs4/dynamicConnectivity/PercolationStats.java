package algs4.dynamicConnectivity;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class PercolationStats {

    private double[] tests;
    private int T;
    /**
     * perform T independent computational experiments on an N-b-N grid
     */
    public PercolationStats(int N, int T) {
        if(N <=0 || T<=0) {
            throw new IllegalArgumentException("N and T must be greater than zero.");
        }

        this.tests = new double[T];
        this.T = T;
    }

    /**
     * sample mean of percolation threshold
     */
    public double mean() {
        return StdStats.mean(tests);
    }

    /**
     * sample standard deviation of percolation threshold
     */
    public double stddev() {
        return new StandardDeviation().evaluate(tests);
    }

    /**
     * return lower bound of 95% confidence level
     */
    public double confidenceLo() {
        return mean() - 1.96 * Math.pow(stddev(), .5) / Math.pow(T, .5);
    }

    /**
     * returns upper bound of the 95% confidence level
     */
    public double confidenceHi() {
        return mean() + 1.96 * Math.pow(stddev(), .5) / Math.pow(T, .5);
    }

    public static void main(String[] args) {

    }
}
