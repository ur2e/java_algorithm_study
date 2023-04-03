
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder answer = new StringBuilder();
    static int[] arr;

    static void checkNumber(int n) {
        int lt = 0, rt = arr.length-1;
        int exist = 0;
        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(arr[mid] == n) {
                exist = 1;
                break;
            } else if(arr[mid] > n) rt = mid-1;
            else lt = mid+1;
        }
        answer.append(exist).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // 이분 검색
        for(int i = 0; i < n; i++){
            checkNumber(Integer.parseInt(st.nextToken()));
        }

        System.out.println(answer);
    }
}
