package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test10866_2 {
	static int front = 10000;
	static int back = 10000;
	static int size = 0;
	static int[] deque = new int[20001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] action = br.readLine().split(" ");

			switch(action[0]) {

			case "push_front": 
				push_front(Integer.parseInt(action[1]));
				break;

				case "push_back":
					push_back(Integer.parseInt(action[1]));
					break;

				case "pop_front":
					sb.append(pop_front()).append('\n');
					break;

				case "pop_back":
					sb.append(pop_back()).append('\n');
					break;

				case"size":
					sb.append(size()).append('\n');
					break;

				case "empty":
					sb.append(empty()).append('\n');

				case "front":
					sb.append(front()).append('\n');
					break;

				case "back":
					sb.append(back()).append('\n');
					break;
			}
		}
	}
	static void push_front(int n) {
		deque[front] = n;
		front--;
		size++;
	}
	static void push_back(int n) {
		back++;
		size++;
		deque[back] = n;
	}
	static int pop_front() {
		if(size == 0) {
			return -1;
		}
		int res = deque[front + 1];
		front++;
		size--;
		return res;
	}
	static int pop_back() {
		if(size == 0) {
			return -1;
		}
		int res = deque[back];
		back--;
		size--;
		return res;
	}
	static int size() {
		return size;
	}
	static int empty() {
		return size == 0 ? 1 : 0;
	}
	static int front() {
		return size == 0 ? -1 : deque[front + 1];
	}
	static int back() {
		return size == 0 ? -1 : deque[back];
	}

}
