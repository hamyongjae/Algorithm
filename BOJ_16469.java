package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


// BOJ_16469
// 소년 점프
public class BOJ_16469 {

	static int R, C;
	static boolean visited[][];
	static int cnt2[][];
	static int cnt[][];
	static int map[][];
	static int dx[] = { 1, 0, -1, 0 }; // 오른쪽, 아래, 왼쪽, 위쪽, 제자리
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1];
		cnt = new int[R + 1][C + 1];
		cnt2 = new int[R + 1][C + 1];
		;

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < str.length(); j++)
				map[i][j + 1] = str.charAt(j) - '0';
		}

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			BFS(new Point(x, y, 1));
		}

		int min = Integer.MIN_VALUE;
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (cnt[i][j] != 0 && cnt2[i][j]==3)
					max = Math.max(cnt[i][j], min);
			}
		}

		int temp = 0;

		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
			
		else {
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (min == cnt[i][j])
						temp++;
				}
			}
			System.out.println(min / 3);
			System.out.println(temp);
		}
	}

	public static void BFS(Point p) {
		Queue<Point> Q = new LinkedList<>();
		visited = new boolean[R + 1][C + 1];
		visited[p.y][p.x] = true;
		cnt2[p.y][p.x] += 1;
		Q.add(p);
		while (!Q.isEmpty()) {
			int x = Q.peek().x;
			int y = Q.peek().y;
			int dist = Q.peek().dist;
			cnt[y][x] += dist;
			Q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || C < nx || ny < 1 || R < ny)
					continue;

				if (!visited[ny][nx] && map[ny][nx] == 0) {

					Q.add(new Point(nx, ny, dist + 1));
					visited[ny][nx]=true;
					cnt2[ny][nx]++;
				}
			}
		}
	}
}

class Point {
	int x, y, dist;

	public Point(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
