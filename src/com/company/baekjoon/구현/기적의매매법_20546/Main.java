package com.company.baekjoon.구현.기적의매매법_20546;

import java.io.*;
import java.util.StringTokenizer;


class Stock {
    int cash;
    int count;
    Stock (int cash, int count){
        this.cash = cash;
        this.count = count;
    }

    public int calMoney(int cash, int price, int count){
        return cash + (price * count);
    }
}
public class Main {

     Stock bnp(int cash, int[] stock){
        int count = 0;

        for(int i = 1; i <= 14; i++){
            // 그 날 주식 가격이 가진 현금보다 싸
            if(stock[i] <= cash) {
                while(stock[i] <= cash){
                    cash -= stock[i];
                    count++;
                }
            }

            if(cash == 0) break;
        }

        return new Stock(cash, count);
        // 무조건 다 사
        // stock[i]를 비교해서 가진 cash를 털어
        // 각자 현금 + 가진 주식의 갯수 count
    }

    Stock timing(int cash, int[] stock){
         int count = 0;
         int buy = 0;
         int sell = 0;

         for(int i =2 ; i <=14; i++){
             // 상승
             if(stock[i] > stock[i-1]){
                 buy++;
                 sell = 0;
                 // 다 팔아
                 if(buy >= 3 ) {
                     cash += count * stock[i];
                     count = 0;
                 }
             }
             // 하락
             else if (stock[i] < stock[i-1]){
                 sell++;
                 buy = 0;
                 // 다 사
                 if(sell >= 3){
                     while(stock[i] <= cash) {
                         cash -= stock[i];
                         count++;
                     }
                 }
             }
             else {
                 buy = 0; sell = 0;
             }
         }
        // = + + - - -
         return new Stock(cash, count);
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stock = new int[15];

        for(int i = 1; i <= 14; i++){
            stock[i] = Integer.parseInt(st.nextToken());
        }

        Stock A = T.bnp(cash, stock);
        Stock B = T.timing(cash, stock);

        int price = stock[14];
        if (A.calMoney(A.cash, price, A.count) > B.calMoney(B.cash, price, B.count)) {
            System.out.println("BNP");
        } else if (A.calMoney(A.cash, price, A.count) == B.calMoney(B.cash, price, B.count)) {
            System.out.println("SAMESAME");
        } else {
            System.out.println("TIMING");
        }

    }
}
