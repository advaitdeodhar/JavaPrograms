package org.example;

public class Swipe {
    public static void main(String[] args) {
        int a = -20;
        int b = 55;

        System.out.println(a);
        System.out.println(b);

        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println(a);
        System.out.println(b);

        int i = Integer.MAX_VALUE;

    }
}
