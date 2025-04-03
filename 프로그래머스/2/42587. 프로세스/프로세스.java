import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> qu = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++){
            qu.offer(new int[] {priorities[i], i});
            pq.offer(priorities[i]);
        }
        
        int cnt = 0;
        
        while(!qu.isEmpty()){
        
            int[] cur = qu.poll();
            
            System.out.println(cur[0] + "," + cur[1]);
            
            if(cur[0] == pq.peek()){
                
                pq.poll();
                
                cnt++;
                
                if(cur[1] == location) {
                    return cnt;
                }
            } 
            else {
                qu.offer(cur);
            }
        }
        
        return -1;
    }
}