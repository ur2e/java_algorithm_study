import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
       완전탐색으로 문제를 풀기 전에 고려해야할 사항

        1) 해결하고자 하는 문제의 가능한 경우의 수를 대략적으로 계산한다.
            1초 = 대략 1억개의 연산
        2) 가능한 모든 방법을 다 고려한다.
        3) 실제 답을 구할 수 있는지 적용한다.
     */
    static int n, answer;
    static int[] time, pay;

    private static void dfs(int day, int money) {
        // 상담을 하거나 안 하거나
        if(day == n+1) {
            answer = Math.max(money, answer);
        } else {
            if(n-day+1 >= time[day-1])
                dfs(day + time[day-1], money + pay[day-1]);
            dfs(day + 1, money );
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new int[n];
        pay = new int[n];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            time[i] = Integer.parseInt(tmp[0]);
            pay[i] = Integer.parseInt(tmp[1]);
        }

        dfs(1, 0);

        System.out.println(answer);
    }
}
