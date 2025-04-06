import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K && pq.size() >= 2) {
            
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a + b * 2);
            
            answer++;
            
        }
        
        if(K > pq.peek()){
            return -1;
        }
        return answer;
    }
}