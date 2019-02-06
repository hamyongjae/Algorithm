package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_1719번
// 택배
// 다익스트라 알고리즘
public class BOJ_1719 {

	static int n, m, from, to, w;
	static ArrayList<Edge_1753> map[];
	static int answer[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // vertex
		m = Integer.parseInt(st.nextToken()); // edge

		answer = new int[n + 1][n + 1];
		map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			map[from].add(new Edge_1753(to, w));
			map[to].add(new Edge_1753(from, w));
		}

		for (int i = 1; i <= n; i++)
			Dijskstra(i);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (answer[i][j] == 0)
					System.out.print("- ");
				else
					System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void Dijskstra(int START_V) {
		int dist[] = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Queue<Edge_1753> q = new PriorityQueue<Edge_1753>();
		dist[START_V] = 0;
		q.add(new Edge_1753(START_V, 0));

		while (!q.isEmpty()) {
			Edge_1753 cur = q.poll();

			if (dist[cur.to] < cur.w)
				continue;

			for (Edge_1753 e : map[cur.to]) {
				if (dist[e.to] > dist[cur.to] + e.w) {
					dist[e.to] = dist[cur.to] + e.w;

					answer[e.to][START_V] = cur.to;
					q.add(new Edge_1753(e.to, e.w));
				}
			}
		}
	}
}

class Edge_1753 implements Comparable<Edge_1753> {
	int to, w;

	public Edge_1753(int idx, int w) {
		this.to = idx;
		this.w = w;
	}

	public int compareTo(Edge_1753 o) {
		return this.w > o.w ? 1 : -1;
	}
}