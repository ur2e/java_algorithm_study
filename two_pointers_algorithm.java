//
// �� �迭 ��ġ��
//
// ���ĸ� ���� �� 
// ������ = n*logn ... 
// o(n) ��ŭ�� ���⸦ �ٶ��� -> two pointer ����
//
//

import java.util.*;
  
public class Main {
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		ArrayList<Integer> answer = new ArrayList<>();
		int p1 = 0, p2 = 0;

		// �迭 �ϳ��� Ž���� ������ ���� 
		// p1 < n || p2  < m �ƴϴ�. !!
		while(p1 < n && p2 < m){
			if( a[p1] <= b[p2] ){
				answer.add(a[p1++]);
				/*
				 *  �� ��... �� �ٷ� ����.. 
				answer.add(a[p1]);
				p1++;
				*/
			} else{
				answer.add(b[p2++]);
			}
		}
		
		// a �迭�� �����ִٸ� .. �����̸� �˾Ƽ� �Ѿ�� 
		while(p1 < n) answer.add(a[p1++]);
		// b �迭�� �����ִٸ� 
		while(p2 < m) answer.add(b[p2++]);


		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		// a �迭 ���� 
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		// b �迭 ����
		int m = sc.nextInt();
		int[] b = new int[m];
		for(int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}

		for(int x : T.solution(n, m, a, b))
			System.out.print(x + " ");
	}
}


