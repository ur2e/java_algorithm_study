package com.company.java_algorithm_study.Section7_Recursive.BFS_이진트리순회;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Main {
    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root); // add로도 가능
        int L = 0; // L = level

        // 비어있으면 참. 여기에 부정이니까
        // 비어있으면 거짓
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for(int i = 0; i < len; i++) {
                Node curr = Q.poll();
                System.out.print(curr.data + " ");
                if(curr.lt != null) Q.offer(curr.lt);
                if(curr.rt != null) Q.offer(curr.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Main tree=new Main();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.BFS(tree.root);
    }
}
