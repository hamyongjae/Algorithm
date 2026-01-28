import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> termMap = new HashMap<>();
        
        for(String t : terms){
            
            String[] str = t.split(" ");
            
            termMap.put(str[0], Integer.parseInt(str[1]) * 28);
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            
            if(toDays(str[0]) + termMap.get(str[1]) <= toDays(today)) {
                list.add(i+1);
            }
        }
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static int toDays(String Date){
        
        String[] tmp = Date.split("\\.");
        
        return Integer.parseInt(tmp[0]) * 12 * 28 + Integer.parseInt(tmp[1]) * 28 + Integer.parseInt(tmp[2]);        
    }
}