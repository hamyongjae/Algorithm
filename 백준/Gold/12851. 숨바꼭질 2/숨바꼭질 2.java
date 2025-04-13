import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] visited = new int[100001];
    static int min_time = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N);

        System.out.println(min_time - 1);
        System.out.println(cnt);
    }

    public static void BFS(int start){
        Queue<Integer> qu = new LinkedList<>();

        qu.add(start);
        visited[start] = 1; // 1로 시작해서 나중에 -1 해줌

        while(!qu.isEmpty()){
            int now = qu.poll();

            if(now == K){
                int time = visited[now];

                if (cnt == 0) {
                    min_time = time;
                    cnt = 1;
                } else if (min_time == time) {
                    cnt++;
                }
                continue; // 더 이상 탐색할 필요 없음
            }

            for(int next : new int[] {now + 1, now - 1, now * 2}){
                if(0 <= next && next <= 100000){
                    if(visited[next] == 0 || visited[next] == visited[now] + 1){
                        qu.add(next);
                        visited[next] = visited[now] + 1;
                    }
                }
            }
        }
    }
}