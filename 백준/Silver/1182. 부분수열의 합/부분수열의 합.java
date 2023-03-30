

import java.util.Scanner;

public class Main {
    static int answer = 0;
    static int[] arr, sub, ch;
    static int n, s;
    private void dfs(int L, int num){
        if(L == n) return;
        else {
            for(int i = num; i < n; i++){
                sub[L] = arr[i];

                int sum = 0;
                for(int j = 0; j <= L; j++){
                    sum += sub[j];
                }
                if(sum == s) answer++;

                dfs(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];
        sub = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.dfs(0, 0);
        System.out.println(answer);
    }
}
