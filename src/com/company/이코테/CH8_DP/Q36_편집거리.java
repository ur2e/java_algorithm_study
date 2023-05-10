package com.company.이코테.CH8_DP;

import java.util.Scanner;

public class Q36_편집거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int n = str1.length();
        int m = str2.length();
        int answer = 0;
        int lt = 0;
        int need = 0;
        for (int i = 0; i < n; i++) {
            if(str1.charAt(i) == str2.charAt(lt)) {
                lt++;
                continue;
            } else {
                int j = lt;
                while(j < m && str1.charAt(i) != str2.charAt(j)){
                    j++;
                }
                if(j != m){
                    if(need == 0)   answer += j-lt;
                    else {
                        answer += Math.max(need, j-lt);
                        need = 0;
                    }
                    lt = j+1;

                } else {
                    need++;
                }
            }
        }
        System.out.println(answer);
    }
}
