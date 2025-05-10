import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, L;
    static int[][] map;

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static Map<Integer, Character> direction_map = new HashMap<>();
    static Deque<int[]> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken()) - 1;

            map[R][C] = 1; // 사과는 1

        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);

            direction_map.put(X, C);
        }

        System.out.println(solve());
    }

    public static int solve() {
        int time = 0;
        int x = 0;
        int y = 0;
        int direction = 0;
        snake.add(new int[]{y, x});
        map[y][x] = 2;

        while (true) {
            
            time++;
            
            int ny = y + dy[direction];
            int nx = x + dx[direction];

            if (ny < 0 || nx < 0 || N <= ny || N <= nx || map[ny][nx] == 2) {
                return time;
            }

            // 사과를 먹었었을때
            if (map[ny][nx] == 1) {
                map[ny][nx] = 2;
                snake.addFirst(new int[]{ny, nx});
            }
            // 사과를 안먹었을때
            else {
                map[ny][nx] = 2;
                snake.addFirst((new int[]{ny, nx}));

                int[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            x = nx;
            y = ny;

            if(direction_map.containsKey(time)){
                char dir = direction_map.get(time);

                if(dir == 'L') {
                    direction = (direction + 3) % 4;
                } else if(dir == 'D')
                    direction = (direction + 1) % 4;
            }
        }
    }
}

