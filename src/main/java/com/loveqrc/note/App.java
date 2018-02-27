package com.loveqrc.note;

public class App {
    private static int i;

    public static void main(String[] args) {
        System.out.println(100 % 3);
        System.out.println(100 % 3.0);
        System.out.println(i);
        String str = new String("good");
        change(str);
        System.out.println(str);
        char[] values = {'a', 'b', 'c'};
        change(values);
        System.out.println(values);

        int a = 2;
        int b = 3;

        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));

    }

    public static void change(String string) {
        string = "hello";
    }


    public static void change(char[] values) {
        values[0] = 'g';
    }


}
