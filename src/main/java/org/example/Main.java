package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    private double a = 2.3;
    private double EPS = 1e-3;

    public double function(double x){

        double y;

        if (x <= 0.3+EPS){
            y = 1.5 * a * Math.pow(Math.cos(x), 2);
        } else if (x > 0.3 && x <= 2.3+EPS) {
            y = Math.pow((x - 2), 2) + 6 * a;
        } else {
            y = 3 * a * Math.tan(x);
        }

        return y;
    }

    public double[] fillX (double start, double end, double step){
        int n = calculateSteps(start, end, step);
        return IntStream.range(0, n).mapToDouble(i -> start + i * step).toArray();
    }

    public double[] fillY(double[] x){
        return Arrays.stream(x).map(this::function).toArray();
    }

    private int calculateSteps(double start, double end, double step) {
        return (int) Math.round((end - start) / step + 1);
    }

    public double biggestY(double[] yArr){
        Arrays.sort(yArr);
        return yArr[yArr.length - 1];
    }

    public double leastY(double[] yArr){
        Arrays.sort(yArr);
        return yArr[0];
    }

    public double yArraySum(double[] yArr){
        return Arrays.stream(yArr).sum();
    }

    public double yArithmeticMean(double[] yArr){
        return yArraySum(yArr) / yArr.length;
    }

}