import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // 기본 시간(분) / 기본 요금(원) / 단위 시간(분) /단위 요금(원)

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> result_map = new HashMap<>();      // 결과값 저장

        // 주차시간 누적시키기
        for (int i = 0; i < records.length; i++) {
            String car_record[] = records[i].split(" ");

            if (car_record[2].equals("IN")) {
                // 입차일 경우 ( 차량번호(key) , 입차시간(value) ) 형태로 map 에 저장
                map.put(car_record[1], hourtomin(car_record[0]));
            } else if (car_record[2].equals("OUT")) {
                // 출차일 경우
                int parking_time = map.get(car_record[1]);   // 주차시간
                int exiting_time = hourtomin(car_record[0]); // 출차시간

                int cal_time = exiting_time - parking_time; // 계산해야되는 시간(분)

                if (result_map.get(car_record[1]) == null)
                    result_map.put(car_record[1], cal_time);
                else
                    result_map.put(car_record[1], result_map.get(car_record[1]) + cal_time);

                map.remove(car_record[1]);
            }
        }

        // 남은 차 계산
        for (String key : map.keySet()) {
            int time = 0;
            if (result_map.get(key) != null)
                time = result_map.get(key);

            int cal_time = 1439 - map.get(key);

            result_map.put(key, time + cal_time);
        }

        List<String> al = new ArrayList<>(result_map.keySet());

        // 키 값으로 오름차순 정렬
        Collections.sort(al);

        answer = new int[al.size()];
        int idx = 0;

        // 금액계산
        for (String key : al) {

            int time = result_map.get(key); // 해당 차의 주차 총 시간 (분)

            // 기본시간보다 적으면
            if (time <= fees[0]) {
//                result_map.put(key, fees[1]);
                answer[idx] = fees[1];
            }
            // 기본시간보다 많으면
            else {
                double tmp = Math.ceil((time - fees[0]) / (double) fees[2]);
                answer[idx] = fees[1] + (int) tmp * fees[3];
            }
            idx++;
        }

        return answer;
    }

    public int hourtomin(String time) {
        String tmp[] = time.split(":");
        int hour = Integer.parseInt(tmp[0]); // 시간
        int minutes = Integer.parseInt(tmp[1]); // 분

        return hour * 60 + minutes;
    }
}