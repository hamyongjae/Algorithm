import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> qu = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            qu.offer((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while(!qu.isEmpty()){
            
            int cnt = 1;
            int tmp = qu.poll();
            
            while(!qu.isEmpty() && tmp >= qu.peek()){
                qu.poll();
                cnt++;
            }
            
            list.add(cnt);
        }
        
        return list.stream()
                    .mapToInt(i -> i)
                    .toArray();
    }
}