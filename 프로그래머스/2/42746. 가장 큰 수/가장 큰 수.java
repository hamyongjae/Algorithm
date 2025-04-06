import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String str_arr[] = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numbers.length; i++){
            str_arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str_arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        for(String str : str_arr)
            sb.append(str);
        
        if(str_arr[0].equals("0")){
            return "0";
        }
        
        return sb.toString();
    }
}