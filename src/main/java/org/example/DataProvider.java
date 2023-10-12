package org.example;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "dataForFunction")
    public static Object[][] dataForFunction(){
        return new Object[][]{
                {0.3, 3.149},
                {2.3, 13.89},
                {2.6, -4.151}
        };
    }

    @org.testng.annotations.DataProvider(name = "dataForFillX")
    public static Object[][] dataForFillX(){
        return new Object[][]{
                {50, 0.3},
                {1050, 2.3},
                {1300, 2.8}
        };
    }

    @org.testng.annotations.DataProvider(name = "dataForFillY")
    public static Object[][] dataForFillY(){
        return new Object[][]{
                {50, 3.149},
                {1050, 13.89},
                {1300, -4.151}
        };
    }

}
