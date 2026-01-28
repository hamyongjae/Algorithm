import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        // 05:34 5961 IN
        
        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> totalTime = new HashMap<>();
        
        // 총 주차시간
        for(String record : records) {
            String[] r = record.split(" ");
            
            int time = toMinutes(r[0]);
            String car = r[1];
            String type = r[2];
            
            if(r[2].equals("IN")){
                inMap.put(car, time);
            } else {
                int in = inMap.remove(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + time - in);
            }
        }
        
        // 출차 안된차 23:59 출차처리
        
        int end = toMinutes("23:59");
        for(String car : inMap.keySet()){
            int in = inMap.get(car);
            
            totalTime.put(car, totalTime.getOrDefault(car, 0) + end - in);
        }
        
        List<String> carList = new ArrayList<>(totalTime.keySet());
        Collections.sort(carList);
        
        int[] answer = new int[carList.size()];
        
        for(int i = 0; i < carList.size(); i++){
            int time = totalTime.get(carList.get(i));
            int fee = fees[1];
            
            if(time > fees[0]){
                fee += Math.ceil((time - fees[0]) / (double) fees[2])  * fees[3];
            }
            
            answer[i] = fee;
        }
        
        
        
        return answer;
    }
    
    public static int toMinutes(String time){
        
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        
    }
}