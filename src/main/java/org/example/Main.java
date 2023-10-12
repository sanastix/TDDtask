package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public double function(double x){

        //function №5

        double y;
        double a = 2.3;

        if (x <= 0.3){
            y = 1.5 * a * Math.pow(Math.cos(x), 2);
        } else if (x <= 2.3) {
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

}