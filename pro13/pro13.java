package problem;

import java.util.Stack;

public class pro13 {
	public static void main(String args[]) {
		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };

		int moves[] = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(solution(board, moves));
	}

	static int solution(int board[][], int moves[]) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;

		for (int i = 0; i < moves.length; i++) {
			int idx = moves[i] - 1;
			for (int j = 0; j < board.length; j++) {
				if (board[j][idx] != 0) { // 해당 열의 인형이 있으면
					if (!stack.isEmpty() && stack.peek() == board[j][idx]) { // 뽑을 인형과 스택의 맨위 인형이 같으면 팝하고 result값 증가
						stack.pop();
						result++;
					} else {
						stack.push(board[j][idx]); // 다르면 스택에 푸시
					}
					
					board[j][idx] = 0; // 뽑은 인형의 2차원 배열의 값은 0으로 변경
					break;
				}

			}
		
		}
		
		return result*2; // 스택에서 pop한 횟수*2를 하여 사라진 인형의 개수 리턴
	}
}
