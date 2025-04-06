class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int sum = brown + yellow;
        // 가로 > 세로
        
        for(int h = 3; h < sum; h++){
            if(sum % h == 0) {
                int w = sum / h;
                
                if(w >= h){
                    if((h-2) * (w-2) == yellow) {
                        answer = new int[] {w,h};
                    } 
                }
            }
        }
        
        return answer;
    }
}