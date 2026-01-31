class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        DFS(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int target, int idx, int sum) {
        
        if(idx == numbers.length) {
            if(sum == target){
                answer++;
            }
            
            return;
        }
        
        DFS(numbers, target, idx + 1, sum + numbers[idx]);
        DFS(numbers, target, idx + 1, sum - numbers[idx]);
        
    }
}