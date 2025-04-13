import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;
    static char[][] map;
    static Queue<Point> waterqu = new LinkedList<>();
    static Queue<Point> dochiqu = new LinkedList<>();

    static class Point {
        int x;
        int y;
        int time;

        public Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'S')
                    dochiqu.add(new Point(i, j, 0));
                else if (map[i][j] == '*')
                    waterqu.add(new Point(i, j, 0));
            }
        }

        while (!dochiqu.isEmpty()) {

            // 물 이동
            int wsize = waterqu.size();

            for (int i = 0; i < wsize; i++) {
                Point cur_p = waterqu.poll();

                for (int d = 0; d < 4; d++) {
                    int ny = cur_p.y + dy[d];
                    int nx = cur_p.x + dx[d];

                    if (ny < 0 || nx < 0 || R <= ny || C <= nx) {
                        continue;
                    }
                    if (map[ny][nx] == '.') {
                        map[ny][nx] = '*';
                        waterqu.add(new Point(ny, nx, cur_p.time + 1));
                    }
                }
            }

            // 고슴도치 이동
            int dsize = dochiqu.size();

            for (int i = 0; i < dsize; i++) {

                Point cur_p = dochiqu.poll();
                visited[cur_p.y][cur_p.x] = true;

                for (int d = 0; d < 4; d++) {
                    int ny = cur_p.y + dy[d];
                    int nx = cur_p.x + dx[d];

                    if (nx < 0 || ny < 0 || R <= ny || C <= nx)
                        continue;

                    if (map[ny][nx] == 'D') {
                        System.out.println(cur_p.time + 1);
                        return;
                    }

                    if (map[ny][nx] == '.' && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        dochiqu.add(new Point(ny, nx, cur_p.time + 1));
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }
}
