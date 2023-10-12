package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

}
