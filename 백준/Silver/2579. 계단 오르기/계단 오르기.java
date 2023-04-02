
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stair = new int[n+1];
        int[] d = new int[n+1];

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            stair[i] = sc.nextInt();
        }
        d[1] = stair[1];

        if(n > 1) {
            if( n > 2) {
                d[2] = stair[1] + stair[2];
                for (int i = 3; i <= n; i++) {
                    d[i] = Math.max(d[i - 2] + stair[i], d[i-3] + stair[i-1] + stair[i]);
                    //System.out.println(i +"번째 : " + d[i]);
                }
                
                answer = d[n];
            }
            else {
                answer = stair[1] + stair[2];
            }
        } else {
            answer = stair[1];
        }

        System.out.println(answer);
    }
}