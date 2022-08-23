package com.company.baekjoon.구현.HTML파싱_22859;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ">");
        String str =  st.nextToken(">"); // 시작 부분은 지워
        StringBuilder answer = new StringBuilder();
        while(!(str = st.nextToken()+">").equals("</main>")) {
            // title 어케 떼지
            String title = str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\""));
            answer.append("title : ").append(title).append("\n");
            StringBuilder sb = new StringBuilder();
            while(!(str = st.nextToken()+">").contains("</div>")) {
                boolean check = false;
                boolean trimCheck = false;
                if(str.contains("<p>")) continue;
                boolean flag = true;
                for(char x: str.toCharArray()){
                    if(x == '<')    flag = false;
                    else if(x == '>') flag = true;
                    else if (flag) {
                        if(x == ' '){
                            if(sb.lastIndexOf(" ") == sb.length()-1){
                                continue;
                            } else {
                                sb.append(' ');
                            }
                        } else {
                            sb.append(x);
                        }
                    }
                }
                if(str.contains("</p>")) {
                    //sb.append(str.substring(0, str.indexOf("<")));
                    answer.append(sb.toString().trim()).append("\n");
                    sb = new StringBuilder();
                    continue;
                }
            }
        }
        answer.deleteCharAt(answer.lastIndexOf("\n"));
        System.out.println(answer);
    }
}