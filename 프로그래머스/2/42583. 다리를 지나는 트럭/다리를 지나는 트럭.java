import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> qu = new LinkedList<>();
        
        int current_weight = 0;
        int time = 0;
        
        for(int i = 0; i < truck_weights.length; i++){
            
            while(true) {
                
                if(qu.size() == bridge_length)
                    current_weight -= qu.poll();
                
                if(truck_weights[i] + current_weight <= weight) {
                    qu.add(truck_weights[i]);
                    current_weight += truck_weights[i];
                    time++;
                    break;
                } else {
                    qu.add(0);
                    time++;
                }
            }
        }
        
        return time + bridge_length;
    }
}