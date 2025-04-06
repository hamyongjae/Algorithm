import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            
            // 가격이 떨어지면 스택 처리
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            
            stack.push(i); // 인덱스 저장
        }
        
        // 끝까지 가격이 안 떨어진 애들 처리
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }
        
        return answer;
    }
}