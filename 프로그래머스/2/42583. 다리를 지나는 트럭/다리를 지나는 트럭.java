import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> qu = new LinkedList<>();

        int cur_weights = 0;
        int time = 0;
        int idx = 0;

        // 다리 초기화
        for (int i = 0; i < bridge_length; i++) {
            qu.add(0);
        }

        while (idx < truck_weights.length) {

            time++;

            cur_weights -= qu.poll();

            if (cur_weights + truck_weights[idx] <= weight) {
                qu.add(truck_weights[idx]);
                cur_weights += truck_weights[idx];
                idx++;
            } else {
                qu.add(0);
            }
        }

        return time + bridge_length;
    }
}
