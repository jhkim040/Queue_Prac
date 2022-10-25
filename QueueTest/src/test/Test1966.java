package test;

import java.util.LinkedList;
import java.util.Scanner;

public class Test1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();	// �׽�Ʈ ���̽�
		
		while(T-- > 0) {
			int N = sc.nextInt();	// ���� ���� (1 ~ 100)
			int M = sc.nextInt();   // ���� Queue���� M ��° ( 0 ~ N, �� ������ 0�� ° )
			
			LinkedList<int[]> q = new LinkedList<>();
			
			for(int i = 0; i < N; i++) {
				q.offer(new int[] {i, sc.nextInt()}); 
				// {�ʱ� ��ġ, �߿䵵}
			}
			int count = 0; // ��� ����
			
			while(!q.isEmpty()) {
				int[] front = q.poll(); // front
				boolean isMax = true;   // front�� �߿䵵�� ���� ū ��?
				
				// �߿䵵 ��
				for(int i = 0; i < q.size(); i++) {

					// front�� �߿䵵�� queue�� i��°���� ������
					if(front[1] < q.get(i)[1]) {
						// front ���� i ��° ��� ���� ��ҵ��� queue �ڷ�
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}
				// front�� �߿䵵�� ���� ũ�� �ʾ��� ���
				if(isMax == false) { // --> ���� �ݺ�
					continue;
				}
				// front�� �߿䵵�� ���� Ŭ ���
				count++;
				if(front[0] == M) { // �ʱ� ��ġ ��
					break; // ó�� ã�����ߴ� ������� ����
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

}
