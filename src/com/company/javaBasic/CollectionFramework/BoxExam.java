package com.company.CollectionFramework;

public class BoxExam {
    public static void main(String[] args) {
        Box box = new Box();
        box.setObj(new Object());
        Object obj = box.getObj();

        box.setObj("hello"); // 가능 why? 상속! Object의 자식클래스들도 들어올 수 있음
        String str = (String)box.getObj(); // 자식메소드를 쓰려면 형변환 필수

        box.setObj(1);
        int value = (int)box.getObj();

        // Object: 모든 객체가 다 들어갈 수 있는데,
        // 꺼낼 때 매번 형 변환을 해줘야 한다.
        // 이 부분을 Generic으로 바꿔보자

        // BoxGeneric에 Object 값을 받을거에요
        BoxGeneric<Object> gBox = new BoxGeneric<>();
        gBox.setObj(new Object());
        Object obj2 = gBox.getObj(); // 형변환 따로 할 필요 X

        // BoxGeneric에 String 값을 받을거에요.
        BoxGeneric<String> gBox2 = new BoxGeneric<>();
        gBox2.setObj("world");
        String str2 = gBox2.getObj(); // 형변환 따로 할 필요 X

        BoxGeneric<Integer> gBox3 = new BoxGeneric<>();
        gBox3.setObj(5); // 오토박싱
        int value2 = gBox3.getObj(); // 형변환 할 필요 X //오토언박싱
    }
}
