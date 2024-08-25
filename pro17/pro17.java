package problem;

import java.util.ArrayDeque;
import java.util.Arrays;

// 카드 뭉치
public class pro17 {

	public static void main(String args[]) {
		System.out.println(solution(new String[] { "i", "drink", "water" }, new String[] { "want", "to" },
				new String[] { "i", "want", "to", "drink", "water" }));
	}

	static String solution(String cards1[], String cards2[], String goal[]) {
		ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
		ArrayDeque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
		
		
        // goal배열의 원소들을 순차적으로 cards1의 원소들로 구성된 queue1과 cards2의 원소들로 구성된 queue2의 맨 앞 값들과 비교		
		for (int k = 0; k < goal.length; k++) {

			if (!queue1.isEmpty() && queue1.peek().equals(goal[k])) {			
				queue1.poll();			
				
			} else if (!queue2.isEmpty() && queue2.peek().equals(goal[k])) {
				queue2.poll();
				
			} else {
				return "No"; // 해당되는 값이 없으면 문자열을 완성할 수 없으므로 No리턴
			}
		}

		return "Yes"; // 반복문을 통과하면 조건에 만족하므로 Yes리턴
	}

}
