import java.util.*;

class Solution {
    
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] visited = new boolean[numbers.length()];
    
        combination(numbers, "", visited);
        
        for(int tmp : set) {
           if(isPrime(tmp))
               answer++;
        }
        return answer;
    }
    
    public void combination(String numbers, String cur, boolean[] visited){
        
        if(!cur.equals("")){
            set.add(Integer.parseInt(cur));
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]) {
                visited[i] = true;
                combination(numbers, cur + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    // 소수 판별 함수
    public boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}