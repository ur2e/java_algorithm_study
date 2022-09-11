package com.company.baekjoon.구현.ZOAC3나중에할래;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Character, Node> l = new HashMap<>();
        char left = st.nextToken().charAt(0);
        char right = st.nextToken().charAt(0);

        l.put('q', new Node(0,0));
    }
}
