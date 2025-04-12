
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] visited = new int[100001];
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N);

        System.out.println(visited[K]);
    }

    public static void BFS(int N){
        Queue<Integer> qu = new LinkedList<>();

        qu.add(N);

        visited[N] = 0;

        int[] dy = {1, -1, 2};

        while(!qu.isEmpty()) {

            int now = qu.poll();

            if(now == K){
                return;
            }

            for(int i = 0; i < 3; i ++){

                int next;

                if(i == 2){
                    next = now * dy[i];
                }
                else {
                    next = now + dy[i];
                }

                if(0 <= next && next <= 100000){
                    if(visited[next] == 0){
                        visited[next] = visited[now] + 1;
                        qu.add(next);
                    }
                }
            }
        }
    }
}