package com.longluo.algorithm;

public class Sqrt {

    private static double[] rect(double a, double b) {
        double nextA = (a + b) / 2;
        double nextB = 2 / nextA;
        return new double[]{nextA, nextB};
    }

    public static void main(String[] args) {
        double[] init = {1, 2};
        for (int i = 0; i < 5; i++) {
            double[] res = rect(init[0], init[1]);
            System.out.println(res[0] + ", " + res[1]);
            init = res;
        }
    }
}
