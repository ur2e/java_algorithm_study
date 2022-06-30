package com.company.java_algorithm_study.Section7_Recursive.BFS_말단노드최단거리;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}
public class Main {
    Node root;
    public int BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                Node curr = Q.poll();
                // 말단노드라면~
                if(curr.lt == null && curr.rt == null) {
                    return L;
                }

                if(curr.lt != null) Q.offer(curr.lt);
                if(curr.rt != null) Q.offer(curr.rt);

                /* 자식이 한 쪽만 있을 수도 있으니까 위처럼 if문 걸어줘야 한다.
                Q.offer(curr.lt);
                Q.offer(curr.rt);
                */
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.BFS(tree.root));
    }
}
