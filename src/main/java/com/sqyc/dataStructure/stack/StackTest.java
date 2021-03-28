package com.sqyc.dataStructure.stack;

import org.junit.Test;

import java.util.Random;
import java.util.Stack;
import java.util.function.Predicate;

public class StackTest {
    private Stack<ObjectTest> load = load();
    private Random random = new Random();

    @Test
    public void test1() {
        for (int i = 0; i < 15; i++) {
            System.out.println(allocate(i));
        }

        System.out.println("============");
        print();
    }

    private ObjectTest allocate(int someCase) {
        Predicate<Integer> condition = value -> (Math.abs(random.nextInt(10) - value)) % 2 == 0;
        if (!load.isEmpty() && !load.peek().isUsed() && condition.test(someCase)) {// 满足条件，返回最近的
            return load.pop();
        }

        // 返回满足条件的
        for (int index = load.size() - 2; index >= 0; index--) {
            ObjectTest element = load.elementAt(index);
            if (!load.isEmpty() && !element.isUsed() && condition.test(someCase)) {
                element.setUsed(true);
                return element;
            }
        }
        return null;
    }

    private void print() {
        for (int i = load.size() - 1; i >= 0; i--) {
            ObjectTest element = load.elementAt(i);
            System.out.println(element);
        }
    }

    private Stack<ObjectTest> load() {
        Stack<ObjectTest> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(new ObjectTest(i, false));
        }
        return stack;
    }

    class ObjectTest {
        private Integer id;
        private boolean isUsed;

        public ObjectTest() {
        }

        public ObjectTest(Integer id, boolean isUsed) {
            this.id = id;
            this.isUsed = isUsed;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public boolean isUsed() {
            return isUsed;
        }

        public void setUsed(boolean used) {
            isUsed = used;
        }

        @Override
        public String toString() {
            return "ObjectTest{" +
                    "id=" + id +
                    ", isUsed=" + isUsed +
                    '}';
        }
    }

}
