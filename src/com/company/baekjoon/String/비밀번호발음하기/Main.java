package com.company.baekjoon.String.비밀번호발음하기;

import java.io.*;

public class Main {
    public boolean alphaCheck(char c){
        char[] vowel = {'a', 'e', 'i', 'o' ,'u'};

        boolean check = false;
        for(char v: vowel){
            if(v == c) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        boolean isAcceptable;

        while(!(str = br.readLine()).equals("end")){
            int vcount = 0;
            int ccount = 0;
            isAcceptable = true;
            if(!str.contains("a") && !str.contains("e") && !str.contains("i") && !str.contains("o") && !str.contains("u")){
                isAcceptable = false;
            }
            else {
                for(int i = 0; i < str.length(); i++){
                    if(T.alphaCheck(str.charAt(i))){
                        vcount++;
                        ccount = 0;
                    }
                    else{
                        ccount++;
                        vcount = 0;
                    }

                    // 연속 두 번
                    if(vcount == 3 || ccount == 3){
                        isAcceptable = false;
                        break;
                    }
                    if(i != 0) {
                        if(str.charAt(i) == str.charAt(i-1)) {
                            if (!(str.charAt(i) == 'e' && str.charAt(i - 1) == 'e') && !(str.charAt(i) == 'o' && str.charAt(i - 1) == 'o')) {
                                isAcceptable = false;
                                break;
                            }
                        }
                    }
                }
            }
            if(isAcceptable) bw.write("<" + str + "> is acceptable.\n");
            else  bw.write("<" + str + "> is not acceptable.\n");
        }
        bw.flush();
    }
}
