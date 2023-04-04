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
            int tmpMax = 0;
            for(int j = i-1; j >= 0; j--){
                if (power[i] < power[j]){
                    tmpMax = Math.max(tmpMax, d[j]);
                }
            }
            d[i] = tmpMax + 1;
            max = Math.max(max, d[i]);
        }

        int answer = n - max;
        System.out.println(answer);

//        for (int i = 1; i <= n; i++) {
//            //System.out.println("-------");
//
//            //System.out.println("현재 병사는 ? : " + i);
//            //System.out.println(power[i-1] + " " + power[i]);
//            // 전투력 내림차순
//            if(power[i-1] > power[i]) {
//                d[i] = d[i-1] + power[i];
//                //System.out.println("내림차순: " + d[i]);
//            }
//
//            // 전투력 오름차순
//            else {
//                // 자신보다 전투력 센 병사 찾기
//                int idx = i-1;
//                int cnt = 0;
//                while(power[idx] < power[i]){
//                    //System.out.println("이 병사 제낀다. " + power[i] + " " + power[idx]);
//                    idx--;
//                    if(idx == -1) {
//                        idx = 0;
//                        break;
//                    }
//                    cnt++; // 열외 병사
//                }
//
//                answer += cnt;
//                //System.out.println("answer" +  answer);
//                d[i] = d[idx] + power[i];
//                //System.out.println(d[i]);
//            }
//        }
//
//        System.out.println(answer);
    }
}
/*
7
10 9 20 8 30 7 50
 */