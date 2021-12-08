//
// 두 배열 합치기
//
// 정렬만 했을 때 
// 퀵정렬 = n*logn ... 
// o(n) 만큼만 돌기를 바란다 -> two pointer 정렬
//
//

import java.util.*;
  
public class Main {
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		ArrayList<Integer> answer = new ArrayList<>();
		int p1 = 0, p2 = 0;

		// 배열 하나의 탐색이 끝나면 종료 
		// p1 < n || p2  < m 아니다. !!
		while(p1 < n && p2 < m){
			if( a[p1] <= b[p2] ){
				answer.add(a[p1++]);
				/*
				 *  뭘 또... 두 줄로 쓰니.. 
				answer.add(a[p1]);
				p1++;
				*/
			} else{
				answer.add(b[p2++]);
			}
		}
		
		// a 배열이 남아있다면 .. 거짓이면 알아서 넘어가게 
		while(p1 < n) answer.add(a[p1++]);
		// b 배열이 남아있다면 
		while(p2 < m) answer.add(b[p2++]);


		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		// a 배열 생성 
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		// b 배열 생성
		int m = sc.nextInt();
		int[] b = new int[m];
		for(int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}

		for(int x : T.solution(n, m, a, b))
			System.out.print(x + " ");
	}
}


