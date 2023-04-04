import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] power = new int[n+1];
        int[] d = new int[n+1];

        for (int i = 1; i <= n; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for(int j = i-1; j >= 0; j--){
                if (power[i] < power[j]){
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
            max = Math.max(max, d[i]);
        }

        int answer = n - (max+1);
        System.out.println(answer);
    }
}
/*
7
10 9 20 8 30 7 50
 */