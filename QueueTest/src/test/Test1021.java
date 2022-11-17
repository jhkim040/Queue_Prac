package test;

import java.util.LinkedList;
import java.util.Scanner;

public class Test1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count = 0; // 2,3 번 연산 횟수 누적 합 변수
		
		int N = sc.nextInt(); // 큐의 크기
		int M = sc.nextInt(); // 추출할 개수
		
		// 1 ~ N 까지 큐에 저장
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		// 추출할 수를 담은 배열
		int[] takeOut = new int[M];
		
		for(int i = 0; i < M; i++) {
			takeOut[i] = sc.nextInt();
		}
		
		
		for(int i = 0; i < M; i++) {
			int target_idx = deque.indexOf(takeOut[i]); // 추출할 수의 인덱스
			int half_idx; // 중앙의 인덱스
			
			// {1,2,3,4} --> half_idx == 1
			// {1,2,3,4,5} --> half_idx == 2
			if(deque.size() % 2 == 0) { // 크기가 짝수일 때
				half_idx = deque.size() / 2 - 1;
			}
			else { // 크기가 홀수일 때
				half_idx = deque.size() / 2;
			}
			// 2번 연산
			// 추출할 수가 중앙값보다 앞에 있으면
			if(target_idx <= half_idx) {
				for(int j = 0; j < target_idx; j++) {
					// 추출할 수 직전까지를 모두 뒤로 이동
					int tmp = deque.pollFirst();
					deque.offerLast(tmp);
					count++;
				}
			}
			// 3번 연산
			// 추출할 수가 중앙값보다 뒤에 있으면
			else {
				for(int j = 0; j < deque.size() - target_idx; j++) {
					// 추출할 수까지 앞으로 이동
					int tmp = deque.pollLast();
					deque.offerFirst(tmp);
					count++;
				}
			}
			// 추출
			deque.pollFirst();
		}
		System.out.println(count);
	}

}








