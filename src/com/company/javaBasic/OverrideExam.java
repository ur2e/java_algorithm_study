package com.company;


import java.util.Objects;

public class OverrideExam {
    String name;
    String number;
    int birthYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverrideExam overrideExam = (OverrideExam) o;
        return Objects.equals(number, overrideExam.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public static void main(String[] args) {
        OverrideExam s1 = new OverrideExam();
        s1.name = "홍길동";
        s1.number = "1234";
        s1.birthYear = 1995;


        OverrideExam s2 = new OverrideExam();
        s2.name = "홍길동";
        s2.number = "1234";
        s2.birthYear = 1995;

        if(s1.equals(s2)) System.out.println("s1 == s2");
        else System.out.println("s1 != s2");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        /*
            아래 두 개는 같은 결과가 나온다.
         */
        System.out.println(s1);
        System.out.println(s1.toString());
    }
}
