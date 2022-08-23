package com.company.baekjoon.DFS_BFS.이모티콘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int count;
    int clip;
    int sec;

    public Node(int count, int clip, int sec) {
        this.count = count;
        this.clip = clip;
        this.sec = sec;
    }
}
class Me{
    private int solution(int n){
        int answer = 0;

        int[][] ch = new int[1001][1001];

        // 그냥 붙여넣기, 복사하고 붙여넣기, 삭제하기
        // 1 + c.clip
        // 1 - 1
        // clip + cx

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0, 0));
        while(!q.isEmpty()){
            Node c = q.poll();
            int ccnt = c.count; // 현재 이모티콘 갯수
            int cclip = c.clip; // 현재 클립보드의 이모티콘 갯수
            int csec = c.sec;
            // 원하는 이모티콘 갯수 충족
            if(ccnt == n) {
                answer = csec;
                break;
            }

            // 붙여넣기
            if(cclip > 0 && ccnt + cclip < 1001  && ch[ccnt + cclip][cclip] == 0) {
                q.offer(new Node(ccnt + cclip, cclip, csec + 1));
                ch[ccnt + cclip][cclip] = 1;
            }

            // 현재꺼 클립보드에 복사 후  붙여넣기
            if(ch[ccnt][ccnt] == 0) {
                q.offer(new Node(ccnt, ccnt, csec + 1));
                ch[ccnt][ccnt] = 1;
            }

            // 이모지 하나 지우기
            if(ccnt - 1 > 1 && ch[ccnt - 1][cclip] == 0) {
                q.offer(new Node(ccnt - 1, cclip, csec + 1));
                ch[ccnt-1][cclip]  = 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Me T = new Me();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(T.solution(Integer.parseInt(br.readLine())));
    }
}