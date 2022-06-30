package com.company.java_algorithm_study.Section7_Recursive.DFS_이진트리순회;

class Node {
    int data;
    Node lt, rt;
    // 생성자
    public Node(int val) {
        data=val;
        lt=rt=null;
    }
}

public class Main {
    // Node 라는 클래스의 객체의 주소를 저장하는 참조형 변수
    Node root;
    public void DFS(Node root){
        // root == null : 말단 노드
        if (root == null) return;
        else {
            // System.out.print(root.data + " "); // : 전위 순위
            DFS(root.lt); // 왼쪽 인데 이걸 호출하면서 왼쪽이 다시 가운데가 된다.
            System.out.print(root.data + " "); // : 중위 순위
            DFS(root.rt); // 오른쪽
            // System.out.print(root.data + " "); // : 후위 순위

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
        // tree.root = 젤 위에 1번 데이터를 가지고 있는 노드이다.
        tree.DFS(tree.root);
    }
}