import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> discountMap = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        // 처음 할인 되는 대상
        for(int i = 0; i < 10; i++){
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        if(wantMap.equals(discountMap)){
            answer++;
        }
        
        for(int i = 10; i < discount.length; i++){
            
            String out = discount[i - 10];
            
            discountMap.put(out, discountMap.get(out) - 1);
            
            if(discountMap.get(out) == 0){
                discountMap.remove(out);
            }
            
            String in = discount[i];
            
            discountMap.put(in, discountMap.getOrDefault(in, 0) + 1);
            
            if(wantMap.equals(discountMap)) answer++;
            
        }
        
        return answer;
    }
}