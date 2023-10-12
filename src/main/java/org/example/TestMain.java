package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestMain {

    private static final double EPS = 1e-3;
    Main main;
    double a;

    @BeforeMethod
    public void setUp(){
        main = new Main();
        a = 2.3;
    }

    @Test(dataProvider = "dataForFunction", dataProviderClass = DataProvider.class)
    public void testFunctionLess(double x, double expected){
        Assert.assertEquals(main.function(x), expected, EPS);
    }

    @Test(dataProvider = "dataForFillX", dataProviderClass = DataProvider.class)
    public void testFillX(int index, double expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        Assert.assertEquals(x[index], expected, EPS);
    }

    @Test(dataProvider = "dataForFillY", dataProviderClass = DataProvider.class)
    public void testFillY(int index, double expected){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] actual = main.fillY(x);
        Assert.assertEquals(actual[index], expected, EPS);
    }

    @Test
    public void testBiggestY(){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        Arrays.sort(y);
        double expected = 16.683;
        Assert.assertEquals(main.biggestY(y), expected, EPS);
    }

    @Test
    public void testLeastY(){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        Arrays.sort(y);
        double expected = -7.692;
        Assert.assertEquals(main.leastY(y), expected, EPS);
    }

    @Test
    public void testYArraySum(){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        double expected = 13594.060;
        Assert.assertEquals(main.yArraySum(y), expected, EPS);
    }

    @Test
    public void testYArithmeticMean(){
        double start = 0.2;
        double end = 2.8;
        double step = 0.002;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        double expected = 10.449;
        Assert.assertEquals(main.yArithmeticMean(y), expected, EPS);
    }

}
