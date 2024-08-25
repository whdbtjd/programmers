package problem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

// 기능 개발
public class pro16 {
	public static void main(String args[]) {
		System.out.println(Arrays.toString(solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 })));
	}

	static int[] solution(int progresses[], int speeds[]) {

		int day = 0;
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		ArrayList<Integer> list = new ArrayList<>(); // 정답을 저장해둘 배열

		for (int i = 0; i < progresses.length; i++) {
			// 해당 기능이 개발되는데 걸리는 시간 계산
			day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            
			// 현재 큐의 가장 오래걸리는 개발시간보다 더 오래걸리는 개발시간이 나오면 큐를 비우고 리스트에 추가
			if (!queue.isEmpty() && queue.peekLast() < day) {
				list.add(queue.size());
				queue.clear();
			}
			
				queue.add(day);
			
		
		}

		// 큐에 남은 원소
		list.add(queue.size());

		return list.stream().mapToInt(x -> x.intValue()).toArray();
	}

}
