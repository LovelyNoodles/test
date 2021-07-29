package com.sqyc.inheritance;

import lombok.Data;

@Data
public class A {

    public void print() {
        System.out.println(A.class.getSimpleName());
    }

    public class As {
        public void print() {
            A.this.print();
        }
    }

}
