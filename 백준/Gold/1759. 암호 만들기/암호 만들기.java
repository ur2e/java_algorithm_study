
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] combi, arr, ch;
    static int l, c;
    private void bfs(int L, int s){
        if (L == l) {
            if(checkPwd(combi)){
                for (char x : combi) {
                    System.out.print(x);
                }
                System.out.println();
            }
        } else {
            for(int i = s; i < c; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    combi[L] = arr[i];
                    bfs(L+1, i+1);
                    ch[i] = 0;
                }
            }
        }
    }

    private boolean checkPwd(char[] arr){
        int ja = 0;
        int mo = 0;
        for (int i = 0; i < arr.length; i++) {
            char x = arr[i];
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if(mo >= 1 && ja >= 2)  return true;
        return false;
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ch = new char[c];
        arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        combi = new char[l];

        T.bfs(0, 0);
    }
}
