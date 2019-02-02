package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ_1753
// 최단경로
// 다익스트라 알고리즘 
public class BOJ_1753 {

	static int V, E, START_V, u, v, w;

	static int[] dist; // 시작점 부터의 거리
	static ArrayList<vertex> map[];
	static PriorityQueue<vertex> pq;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		START_V = Integer.parseInt(br.readLine());

		dist = new int[V + 1];
		map = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			map[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken()); // from
			v = Integer.parseInt(st.nextToken()); // to
			w = Integer.parseInt(st.nextToken()); // 가중치
			map[u].add(new vertex(v, w)); // 인접리스트에 add
		}

		for (int i = 1; i <= V; i++)
			dist[i] = INF; // 초기비용 무한대

		dist[START_V] = 0; // 시작지점 자기 자신 0

		pq = new PriorityQueue<vertex>();
		pq.add(new vertex(START_V, 0));
		while (!pq.isEmpty()) {
			vertex node = pq.poll(); // pq 에서 거리가 최소인 정점을 poll

			if (dist[node.idx] < node.w)
				continue;

			for (vertex adj : map[node.idx]) {
				if (dist[adj.idx] > dist[node.idx] + adj.w) {
					dist[adj.idx] = dist[node.idx] + adj.w;
					pq.add(new vertex(adj.idx, dist[adj.idx]));
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == INF)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}

		System.out.println(sb);
	}
}

class vertex implements Comparable<vertex> {
	int idx, w; // 노드, 거리

	public vertex(int node, int dist) {
		this.idx = node;
		this.w = dist;
	}

	@Override
	public int compareTo(vertex o) {
		return this.w > o.w ? 1 : -1;
		// 파라미터로 넘어온 distance가 더 크면 -1 리턴
		// 여기 있던 distance가 더 크면 1 리턴
	}
}
