import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();

        dp = new int[n + 1];
        if(n == 1)  answer = 0;
        else if(n == 2 || n == 3)    answer = 1;
        else {
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= n ; i++) {
                int min = Integer.MAX_VALUE;
                if(i % 3  == 0) {
                    min = Math.min(min, dp[i/3] + 1);
                }
                if(i % 2  == 0) {
                    min = Math.min(min, dp[i/2] + 1);
                }
                min = Math.min(min, dp[i-1] + 1);

                dp[i] = min;
            }

            answer = dp[n];
        }

        System.out.println(answer);
    }
}
