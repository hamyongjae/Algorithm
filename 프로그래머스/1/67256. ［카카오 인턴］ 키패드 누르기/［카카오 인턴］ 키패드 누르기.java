import java.util.*;

// 맨헤튼 거리 => 
class Solution {
    
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        int[][] pos = {
            {3, 1}
            ,{0, 0}, {0, 1}, {0, 2}
            ,{1, 0}, {1, 1}, {1, 2}
            ,{2, 0}, {2, 1}, {2, 2}
            ,{3, 0}, {3, 1}, {3, 2}
            
        };
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for(int number : numbers) {
            
            if(number == 1 || number == 4 || number == 7){
                
                sb.append("L");
                left = pos[number];
                
            } else if(number == 3 || number == 6 || number == 9){
                
                sb.append("R");
                right = pos[number];
                
            } else if(number == 2 || number == 5 || number == 8 || number == 0) {
                
                int left_dis = Math.abs(left[0] - pos[number][0]) + Math.abs(left[1] - pos[number][1]);
                int right_dis = Math.abs(right[0] - pos[number][0]) + Math.abs(right[1] - pos[number][1]);
                
                if(left_dis < right_dis) {
                    
                    sb.append("L");
                    left = pos[number];     
                    
                } else if(left_dis > right_dis){
                    
                    sb.append("R");
                    right = pos[number];
                    
                } else if(left_dis == right_dis) {
                    
                    if(hand.equals("left")){
                        
                        sb.append("L");
                        left = pos[number];     
                        
                    } else if(hand.equals("right")){
                        
                        sb.append("R");
                        right = pos[number];
                        
                    }
                    
                }
            }
            
        }
        return sb.toString();
    }
}