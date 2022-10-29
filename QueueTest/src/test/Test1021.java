package test;

import java.util.LinkedList;
import java.util.Scanner;

public class Test1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count = 0; // 2,3 �� ���� Ƚ�� ���� �� ����
		
		int N = sc.nextInt(); // ť�� ũ��
		int M = sc.nextInt(); // ������ ����
		
		// 1 ~ N ���� ť�� ����
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		// ������ ���� ���� �迭
		int[] takeOut = new int[M];
		
		for(int i = 0; i < M; i++) {
			takeOut[i] = sc.nextInt();
		}
		
		for(int i = 0; i < M; i++) {
			int target_idx = deque.indexOf(takeOut[i]);
			int half_idx;
			
			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			}
			else {
				half_idx = deque.size() / 2;
			}
			
			if(target_idx <= half_idx) {
				for(int j = 0; j < target_idx; j++) {
					int tmp = deque.pollFirst();
					deque.offerLast(tmp);
					count++;
				}
			}
			else {
				for(int j = 0; j < deque.size() - target_idx; j++) {
					int tmp = deque.pollLast();
					deque.offerFirst(tmp);
					count++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(count);
	}

}








