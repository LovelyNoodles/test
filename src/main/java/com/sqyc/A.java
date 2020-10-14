package com.sqyc;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class A {
    public static final Map<String, AtomicLong> URI_COUNTER = new ConcurrentHashMap<>();

    static {
        System.out.println("static block is running...");
        A.URI_COUNTER.put("abc", new AtomicLong(1L));
    }

    {
        System.out.println("non-static block is running...");
    }

    public A() {
        System.out.println("construct is running...");
    }

    private Integer seq;

    private Integer seq1;

    private String name;

    public BigDecimal amount;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getSeq1() {
        return seq1;
    }

    public void setSeq1(Integer seq1) {
        this.seq1 = seq1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
