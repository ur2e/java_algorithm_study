import java.util.*;

class Main {
	public void DFS(int n){
		if(n == 0) return;
		else{
			// 출력을 먼저하면 3,2,1 순으로 출력
			// System.out.print(n + " ");
			DFS(n-1);
			System.out.print(n + " ");
		}	
	}

	public static void main(String[] args){
		Main T = new Main();
		T.DFS(3);
	}
}
