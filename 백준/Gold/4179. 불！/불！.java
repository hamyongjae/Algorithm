import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static int[][] fireTime;
    static int[][] jihunTime;

    static Queue<int[]> fireQueue = new LinkedList<>();
    static Queue<int[]> jihunQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireTime = new int[R][C];
        jihunTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireTime[i], -1);
            Arrays.fill(jihunTime[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'J') {
                    jihunQueue.add(new int[]{i, j});
                    jihunTime[i][j] = 0;
                } else if (map[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }
        }

        fireBFS(); // 불이 먼저 퍼지고
        jihunBFS(); // 지훈이가 이동

    }

    static void fireBFS() {

        while (!fireQueue.isEmpty()) {
            int cy = fireQueue.peek()[0];
            int cx = fireQueue.peek()[1];

            fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || R <= ny || C <= nx)
                    continue;

                if (map[ny][nx] == '#' || fireTime[ny][nx] != -1)
                    continue;

                fireQueue.add(new int[]{ny, nx});
                fireTime[ny][nx] = fireTime[cy][cx] + 1;

            }
        }
    }

    static void jihunBFS() {

        while (!jihunQueue.isEmpty()) {

            int cy = jihunQueue.peek()[0];
            int cx = jihunQueue.peek()[1];

            jihunQueue.poll();

            // 지훈이가 가장자리 도착해서 탈출하는 경우
            if (cy == 0 || cx == 0 || cy == R - 1 || cx == C - 1) {
                System.out.println(jihunTime[cy][cx] + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] == '#')
                    continue;

                if (jihunTime[ny][nx] != -1)
                    continue;

                if (jihunTime[cy][cx] + 1 < fireTime[ny][nx] || fireTime[ny][nx] == -1) {
                    jihunQueue.add(new int[]{ny, nx});
                    jihunTime[ny][nx] = jihunTime[cy][cx] + 1;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}