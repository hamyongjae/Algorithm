import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            qu.offer((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while(!qu.isEmpty()) {
            int count = 1;
            int front = qu.poll();
            
            
            while(!qu.isEmpty() && front >= qu.peek()) {
                qu.poll();
                count++;
            }
            
            list.add(count);
            
        }
        
        return list.stream()
                    .mapToInt(i -> i)
                    .toArray();
    }
}