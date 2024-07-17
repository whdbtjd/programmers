package problem;

import java.util.ArrayDeque;
import java.util.HashMap;

public class pro10 {
	public static void main(String args[]) {
		System.out.println(solution("}]()[{"));
	}

	static int solution(String text) {
		// 괄호 정보를 저장할 해시맵 생성
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		StringBuilder sb = new StringBuilder(text); // 반복문에서 문자열을 다루기 위해 StringBuilder객체 생성
		ArrayDeque<Character> stack = new ArrayDeque<>();

		int result = 0;

		for (int i = 0; i < text.length(); i++) {

			for (int j = 0; j < text.length(); j++) {
				if (map.containsKey(sb.charAt(j))) { // 열린 괄호일 경우 닫힌괄호 스택에 푸시
					stack.push(map.get(sb.charAt(j)));
				} else if (stack.isEmpty() || sb.charAt(j) != stack.pop()) { // 최근에 푸시된 괄호와 현재 괄호(닫힌괄호)가 일치하지 않으면 break
					break;
				}

				if (j == text.length() - 1 && stack.isEmpty()) { // 마지막 까지 반복문이 작동했을 때 스택이 비어있으면 올바른 괄호문자열
					result++;
				}

			}
			// 스택 재사용을위한 비우기
			stack.clear();
			// 현재 문자열의 첫번째 문자를 제외한 문자열과 첫번째 문자열을 더하여 새로운 문자열을 생성하고, 기존 문자열 삭제
			sb.append(sb.substring(1) + sb.charAt(0));
			sb.delete(0, text.length());

		}

		return result;
	}
}
