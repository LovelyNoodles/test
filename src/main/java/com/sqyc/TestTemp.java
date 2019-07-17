package com.sqyc;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestTemp {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("执行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        TimeUnit.SECONDS.sleep(6);
        System.out.println("kill thread ...");
        System.out.println("interrupted thread ...");

    }


    @Test
    public void test1() {
        BigDecimal decimal1 = new BigDecimal(2.3);
        BigDecimal decimal2 = new BigDecimal(3.5);

        BigDecimal subtract = (subtract = decimal2.subtract(decimal1)).compareTo(BigDecimal.ZERO) >= 0 ? subtract : BigDecimal.ZERO;

        System.out.println(subtract);
        System.out.println(decimal2.subtract(decimal1));
        System.out.println(subtract.compareTo(BigDecimal.ZERO));

    }

    @Test
    public void test2() {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        A a4 = new A();
        A a5 = new A();

        a1.setName("C003");
        a2.setName("C004");
        a3.setName("C002");
        a4.setName("C001");
        a5.setName("C001");

        a1.setAmount(new BigDecimal(2.1));
        a2.setAmount(new BigDecimal(3.25));
        a3.setAmount(new BigDecimal(5.03));
        a4.setAmount(new BigDecimal(6.09));
        a5.setAmount(new BigDecimal(6.09));


        List<A> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);

        Map<String, BigDecimal> collect = list.stream().collect(
                Collectors.groupingBy(A::getName,
                        Collectors.mapping(A::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
        System.out.println(collect);

        List<Map.Entry<String, BigDecimal>> collect2 = collect.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toList());
        System.out.println(collect2);

        List<A> collect1 = list.stream().sorted(Comparator.comparing(A::getName)).collect(Collectors.toList());
        System.out.println(collect1);

    }

    @Test
    public void test3() {
        BigDecimal decimal1 = new BigDecimal(3.2);
        BigDecimal decimal2 = decimal1;
        System.out.println(decimal2 == decimal1);
        BigDecimal decimal3 = decimal1.add(BigDecimal.ZERO);
        System.out.println(decimal3 == decimal1);

        decimal2 = decimal2.subtract(BigDecimal.ONE);
        System.out.println(decimal2 == decimal1);

        System.out.println(decimal1);
        System.out.println(decimal2);
        System.out.println(decimal3);
    }

    @Test
    public void test4() {
        String str = "123412yyp=asdfasd";
        String s = "yyp=1";
        int i = str.lastIndexOf(s);
        String substring = str.substring(i + s.length());
        System.out.println(substring);
    }

    @Test
    public void test5() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(9).plusHours(-6);

        System.out.println(start);
        System.out.println(end);

        System.out.println("开始for");
        for (LocalDate current = start.toLocalDate(); !current.isAfter(end.toLocalDate()); current = current.plusDays(1)) {
            System.out.println(current);
            System.out.println(current.getDayOfWeek());
        }
    }

    @Test
    public void test6() {
        BigDecimal decimal = new BigDecimal(2.08);
        BigDecimal discount = new BigDecimal((100 - 100) * 0.01);
//        BigDecimal discount = new BigDecimal((100 - 0) * 0.01);

        BigDecimal multiply = decimal.multiply(discount);

        System.out.println(decimal);
        System.out.println(multiply);
        System.out.println(multiply.compareTo(BigDecimal.ZERO) == 0);
        System.out.println(multiply.compareTo(decimal) == 0);


    }

}
