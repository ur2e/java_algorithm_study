package com.company.CollectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExam {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        boolean flag1 = set1.add("1 ji");
        boolean flag2 = set1.add("2 yang");
        boolean flag3 = set1.add("3 ji");
        set1.add("4 kim");

        System.out.println(set1.size()); // 2 (중복 값은 세지 않음)

        System.out.println("flag1 = " + flag1); // true
        System.out.println("flag2 = " + flag2); // true
        System.out.println("flag3 = " + flag3); // false


        /*
         * 방법 1)
         * set 자료구조에서 값을 꺼내기 위해서는
         * set의 부모클래스인 Collection이 가지고 있는
         * Iterator 라는 인터페이스를 이용해야한다.
         */
        Iterator<String> iter = set1.iterator();
        while (iter.hasNext()) {
            // 하나 꺼내고 자동으로 다음 값 참조
            String str = iter.next();
            System.out.println(str);
        }

        /*
         * 방법 2) foreach문
         */
        System.out.println("\n방법 2: for문 사용");
        for (String str : set1) {
            // 하나 꺼내고 자동으로 다음 값 참조
            System.out.println(str);
        }

    }
}
