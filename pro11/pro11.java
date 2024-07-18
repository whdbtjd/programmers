package problem;

import java.util.ArrayDeque;

public class pro11 {

	public static void main(String[] args) {
		System.out.println(solution("baabbb"));

	}

	static int solution(String text) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		int result = 0;

		for (int i = 0; i < text.length(); i++) {
			if (stack.isEmpty() || stack.peek() != text.charAt(i)) { // 스택이 비어있거나 스택의 맨위 문자와 현재 문자가 다르면 push
				stack.push(text.charAt(i));
			} else {           // 같으면 pop
				stack.pop();
			}
		}
        
		// 스택이 비어있으면 1, 비어있지않으면 0
		if (stack.isEmpty()) {
			result = 1;
		} else {
			result = 0;
		}

		return result;

	}
}
