import java.util.ArrayList;
import java.util.Scanner;

public class 중복문자제거_contains {
    public StringBuilder Solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] strArr = str.toCharArray();
        //String[] strArr = str.split("");
        ArrayList<Character> charArr = new ArrayList<Character>();
        for(char c : strArr) {
            if(!charArr.contains(c)) {
                charArr.add(c);
                sb.append(c);
            }
        }
        return sb;
    }
    public static void main(String[] args) {
        중복문자제거_contains T = new 중복문자제거_contains();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }
}