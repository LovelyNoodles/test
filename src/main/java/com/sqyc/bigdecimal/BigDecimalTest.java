package com.sqyc.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    @Test
    public void test1() {
        BigDecimal decimal = new BigDecimal(2.456);

        System.out.println(decimal);

        System.out.println(decimal.setScale(0, RoundingMode.UP));
        System.out.println(decimal.setScale(1, RoundingMode.UP));
        System.out.println(decimal.setScale(2, RoundingMode.UP));
        System.out.println(decimal.setScale(3, RoundingMode.UP));

        System.out.println(decimal.setScale(0, RoundingMode.DOWN));
        System.out.println(decimal.setScale(1, RoundingMode.DOWN));
        System.out.println(decimal.setScale(2, RoundingMode.DOWN));
        System.out.println(decimal.setScale(3, RoundingMode.DOWN));

        System.out.println(new BigDecimal(234l));

    }

    @Test
    public void test2() {
        BigDecimal decimal1 = new BigDecimal(0.456);

        BigDecimal decimal2 = decimal1.setScale(0, RoundingMode.DOWN);

        System.out.println(decimal2.compareTo(BigDecimal.ZERO));
        System.out.println(decimal2.equals(BigDecimal.ZERO));

    }

    @Test
    public void test3() {
        BigDecimal bigDecimal = new BigDecimal(2.35);
        System.out.println(bigDecimal.divide(new BigDecimal(2), 0, RoundingMode.DOWN));
        System.out.println(bigDecimal.divide(new BigDecimal(2), 1, RoundingMode.DOWN));
        System.out.println(bigDecimal.divide(new BigDecimal(2), 2, RoundingMode.DOWN));
        System.out.println(bigDecimal.divide(new BigDecimal(2), 2, RoundingMode.CEILING));
    }

    @Test
    public void test4(){
        BigDecimal bigDecimal = new BigDecimal(2.24);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.toPlainString());
    }


}
