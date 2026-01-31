import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        
        for(String r : record) {
            
            String[] commands = r.split(" ");
            
            if(commands[0].equals("Enter") || commands[0].equals("Change")) {
                map.put(commands[1], commands[2]);
            }
        }
        
        for(String r : record) {
            
            String[] commands = r.split(" ");
            
            if(commands[0].equals("Enter")) {
                al.add(map.get(commands[1]) + "님이 들어왔습니다.");
            } else if(commands[0].equals("Leave")){
                al.add(map.get(commands[1]) + "님이 나갔습니다.");
            }
        }
        
        answer = al.toArray(new String[0]);
        
        return answer;
    }
}