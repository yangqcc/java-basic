package com.yqc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by yangqc on 2017/5/4.
 */
public class Lambda {

    private int count;

    public Lambda() {
    }

    public Lambda(int count) {
        this.count = count;
    }

    public static void PrintString(String s, Print<String> print) {
        print.print(s);
    }

    public char toUpperCase(char c) {
        return (char) (c + 21);
    }

    public boolean isNull() {
        return false;
    }

    public static void main(String[] args) {
        PrintString("test", (x) -> System.out.println(x));
        Function<String, String> lambda = String::toUpperCase;
        Lambda lambda1 = new Lambda();
        Function<Character, Character> characterCharacterFunction = lambda1::toUpperCase;
        System.out.println(characterCharacterFunction.apply('c'));

        List<Lambda> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                list.add(null);
            }
            list.add(new Lambda(i));
        }
        list.stream().filter(Lambda::isNull).collect(Collectors.toList()).forEach(System.out::print);
    }
}
