package problem;

import java.util.Stack;

public class pro08 {

	public static void main(String[] args) {
		System.out.println(solution("(())()"));

	}

	public static boolean solution(String text) {
		Stack<Character> stack = new Stack<>();
		int top = -1;
		boolean ans = true;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '(') {    // 열린 괄호일 경우 푸시
				stack.push(text.charAt(i));
				top++;
			} else if (text.charAt(i) == ')') { // 닫힌 괄호일 경우 팝, 스택이 비어있을 경우 올바르지 못한 괄호이므로 flase리턴
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
				top--;

			}

		}
		if (top > -1) { // 반복문을 전부 돌고 스택이 아직 남아있다면 올바르지 못한 괄호이므로 false 리턴 
			ans = false;
		}
		return ans;

	}

}
