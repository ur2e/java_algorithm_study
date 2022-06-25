package com.company.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

public class ListExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1 ji");
        list.add("2 yang");
        list.add("3 kim");


        // size()는 list의 부모메소드인 Collection이 가지고있는 메소드
        // 그래서 Set에서도 똑같이 이용할 수 있다.
        System.out.println(list.size()); //3

        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println("str = " + str);
            // 1 2 3 순서대로 출력
        }
    }
}
