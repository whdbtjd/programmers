package problem;

import java.util.ArrayDeque;
import java.util.Arrays;

public class pro12 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 2, 3 })));

	
	}

	static int[] solution(int prices[]) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		int ans[]=new int[prices.length];
		
		// 스택을 사용해 이전 값과 가격을 비교하여 값이 떨어진 경우의 값을 ans배열에 할당
		for(int i=0;i<prices.length;i++) {
			if(stack.isEmpty()||prices[stack.peek()]<prices[i]) {
				stack.push(i);

			}
			else if(!(stack.isEmpty())&&prices[stack.peek()]>prices[i]) {
				ans[stack.peek()]=i-stack.pop();
				stack.push(i);
			}
			
		}
		
		// 스택이 비어있지 않을 경우 가격이 떨어지지 않은 시간을 세어 ans배열에 값 할당
		for(int i=prices.length-1;i<prices.length;i--) {
			if(!(stack.isEmpty())&&ans[i]==0) {
				ans[i]=(prices.length-1)-stack.pop();
			}
		}
		
		return ans;

	}

}
