package problem;

import java.util.Stack;

public class pro09 {
    public static void main(String args[]) {
        System.out.println(solution(27));  
    }

    static String solution(int num) {
        Stack<Integer> stack = new Stack<>();
        
        StringBuilder answer = new StringBuilder(); // String타입을 사용할경우 문자열이 변경 될 때마다 새로운 객체가 생성되므로 메모리의 자원낭비가 심함
        
        while (num > 0) {
            stack.push(num % 2);
            num = num / 2;
        }
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        
        return answer.toString(); // toString()으로 StringBuilder를 String으로 변환합니다.
    }
}
