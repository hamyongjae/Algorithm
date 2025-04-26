import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(0, 0);

        System.out.println(visited[N - 1][M - 1]);
    }

    static void BFS(int y, int x) {
        Queue<int[]> qu = new LinkedList<>();

        qu.add(new int[]{y, x});
        visited[y][x] = 1;


        while (!qu.isEmpty()) {

            int cy = qu.peek()[0];
            int cx = qu.peek()[1];

            qu.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (0 <= ny && 0 <= nx && ny < N && nx < M && map[ny][nx] == 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[cy][cx] + 1;
                    qu.add(new int[]{ny, nx});
                }
            }
        }

    }
}