import java.util.*;

class Solution {
    static int depth;
    static int[] arr;
    static int answer = 0;
    static int tg; 
    public int solution(int[] numbers, int target) {
        
        
        depth = numbers.length;
        arr = numbers;
        tg = target;
        
        DFS(0, 0);
        
        return answer;
    }
    
    static void DFS(int idx, int sum) {
        if(idx == depth){            
            if(tg == sum)
                answer++;
            
            return;
        }
        
        DFS(idx + 1, sum + arr[idx]);
        DFS(idx + 1, sum - arr[idx]);
    }
}