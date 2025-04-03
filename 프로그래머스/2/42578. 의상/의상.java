import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 의상 종류별 개수 세기
        for(String[] cloth : clothes)
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        
        for(int cnt : map.values()) {
            answer *= cnt + 1;
        }
        
        return answer-1;
    }
}