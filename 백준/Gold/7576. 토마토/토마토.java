import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];

        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    qu.add(new int[]{i, j});
                }
            }
        }

        while (!qu.isEmpty()) {
            int cy = qu.peek()[0];
            int cx = qu.peek()[1];

            qu.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (0 <= ny && 0 <= nx && ny < N && nx < M && map[ny][nx] == 0) {
                    qu.add(new int[]{ny, nx});
                    map[ny][nx] = map[cy][cx] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(map[i][j], max);
            }
        }

        System.out.println(max - 1);

    }

}