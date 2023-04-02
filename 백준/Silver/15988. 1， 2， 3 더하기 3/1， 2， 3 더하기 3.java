

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long[] answer = new long[k];

        for (int j = 0; j < k; j++) {
            int n = sc.nextInt();

            long[] dp = new long[n + 1];

            if(n < 4){
                if(n == 3)   answer[j] = 4;
                else         answer[j] = n;
            }
            else {
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                for (int i = 4; i <= n ; i++) {
                    dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
                }
                answer[j] = dp[n];
            }
        }

        for(long x: answer) {
            System.out.println(x);
        }
    }
}
/*
1
5
50 10 100 20 40
30 50 70 10 60
 */