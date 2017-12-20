package com.ksenobyte;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);

        MyDeque<Integer> myDeque = new MyDeque<>();
        myDeque.add(1);
        myDeque.add(2);
        myDeque.add(3);
        print(arrayDeque, myDeque);

        arrayDeque.push(4);
        myDeque.push(4);
        print(arrayDeque, myDeque);

        arrayDeque.poll();
        myDeque.poll();
        print(arrayDeque, myDeque);

        myDeque.addLast(4);
        arrayDeque.addLast(4);
        print(arrayDeque, myDeque);

        System.out.println(arrayDeque.peek());
        System.out.println(myDeque.peek());
        print(arrayDeque, myDeque);

        System.out.println(myDeque.peekLast());
        myDeque.clear();

    }

    private static void print(ArrayDeque<Integer> arrayDeque, MyDeque<Integer> myDeque) {
        System.out.println(arrayDeque);
        System.out.println(myDeque);
        System.out.println("====================================");
    }
}
