package problem;

import java.util.ArrayDeque;

//요세푸스 문제
public class pro15 {

	public static void main(String args[]) {

		System.out.println(solution(5, 2));

	}

	static int solution(int n, int k) {

		ArrayDeque<Integer> queue = new ArrayDeque<>();

		// 큐 생성
		for (int i = 0; i < n; i++) {
			queue.add(i + 1);
		}

		// 큐의 원소가 1개 남을 때 까지
		while (queue.size() != 1) {

			for (int i = 0; i < k - 1; i++) {
				queue.add(queue.poll()); // 상수시간 소요
			}

			queue.poll(); // k번째 원소 poll()
		}

		return queue.poll();
	}
}
