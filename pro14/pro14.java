package problem;

import java.util.Arrays;
import java.util.Stack;

public class pro14 {
    // 표 편집
	public static void main(String args[]) {
		System.out.println(
				solution(8, 2, new String[] { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" }));
	}

	static String solution(int n, int k, String cmd[]) {

		String result[] = new String[n];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < cmd.length; i++) {

			switch (cmd[i].charAt(0)) {
			
			case 'D':
				int down = cmd[i].charAt(2) - '0';
				k += down;
				break;

			case 'U':
				int up = cmd[i].charAt(2) - '0';
				k -= up;
				break;

			case 'C':
				stack.push(k);
				if (k == n - 1) {
					k--;
				}
				n--;
				break;

			case 'Z':
				if (!stack.isEmpty() && stack.peek() > k) {
					stack.pop();
					n++;
				} else if (!stack.isEmpty() && stack.peek() < k) {
					stack.pop();
					n++;
					k++;
				}
				break;
			}

		}

		while (!stack.isEmpty()) {
			result[stack.pop()] = "X";
		}

		return String.join("", result);
	}

}
