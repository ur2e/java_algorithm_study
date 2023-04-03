import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] d = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        d[0] = 1;
        int answer = 1;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(arr[i] - arr[j] < 0) {
                    max = Math.max(max, d[j]);
                }
            }
            d[i] = max+1;
            answer = Math.max(answer, d[i]);
        }

        System.out.println(answer);
    }
}
