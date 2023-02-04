package com.company.java_algorithm_study.Section1_String.문자찾기;

import java.util.Scanner;

public class Main {
    public int Solution(String str, char c){
        int answer = 0;

        str = str.toLowerCase();
        c = Character.toLowerCase(c);

        /* for 문 :  String.charAt() 으로 비교 */
//        for (int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == c) answer++;
//        }

        /* forEach문 : String을 charArray으로 변경한 후 비교 */
        for (char x : str.toCharArray()) {
            if (x == c) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main(); // static이면 이거 필요 없어
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = sc.next().charAt(0);
        System.out.println(T.Solution(str, c));
    }
}
