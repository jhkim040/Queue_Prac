package test;

import java.util.LinkedList;
import java.util.Scanner;

public class Test1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();	// 테스트 케이스
		
		while(T-- > 0) {
			int N = sc.nextInt();	// 문서 개수 (1 ~ 100)
			int M = sc.nextInt();   // 현재 Queue에서 M 번째 ( 0 ~ N, 맨 왼쪽은 0번 째 )
			
			LinkedList<int[]> q = new LinkedList<>();
			
			for(int i = 0; i < N; i++) {
				q.offer(new int[] {i, sc.nextInt()}); 
				// {초기 위치, 중요도}
			}
			int count = 0; // 출력 순서
			
			while(!q.isEmpty()) {
				int[] front = q.poll(); // front
				boolean isMax = true;   // front의 중요도가 가장 큰 지?
				
				// 중요도 비교
				for(int i = 0; i < q.size(); i++) {

					// front가 중요도가 queue의 i번째보다 낮으면
					if(front[1] < q.get(i)[1]) {
						// front 포함 i 번째 요소 앞의 요소들을 queue 뒤로
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}
				// front의 중요도가 가장 크지 않았을 경우
				if(isMax == false) { // --> 다음 반복
					continue;
				}
				// front의 중요도가 가장 클 경우
				count++;
				if(front[0] == M) { // 초기 위치 비교
					break; // 처음 찾으려했던 문서라면 종료
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

}
