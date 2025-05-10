import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 컴퓨터 수
        M = Integer.parseInt(br.readLine());    // 연결 수

        visited = new boolean[N + 1];           // 방문 배열
        graph = new ArrayList<>();

        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);    // 양방향 연결
            graph.get(b).add(a);
        }

        DFS(1); // 1번 컴퓨터에서 시작

        System.out.println(cnt - 1); // 자기 자신 제외
    }

    // DFS 함수
    static void DFS(int V) {
        visited[V] = true;
        cnt++;

        for (int next : graph.get(V)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
