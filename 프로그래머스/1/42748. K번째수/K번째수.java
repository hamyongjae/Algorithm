import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;  // 인덱스 보정
            int end = commands[i][1];        // end 는 그대로
            int k = commands[i][2] - 1;      // 인덱스 보정
            
            int[] temp = Arrays.copyOfRange(array, start, end);  // 배열 자르기
            Arrays.sort(temp);                                    // 정렬
            answer[i] = temp[k];                                  // k번째 값 넣기
        }
        
        return answer;
    }
}