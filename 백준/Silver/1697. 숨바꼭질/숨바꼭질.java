import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int cnt = 0;
	static int map[] = new int[100001];

	static Queue<Integer> qu = new LinkedList<Integer>();

	public static void main(String agrs[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		BFS(N);
		System.out.println(map[K]-1);
	}

	static void BFS(int N) {
		qu.add(N);
		map[N] = 1;

		if (N == K)
			return;
		
		
		while (!qu.isEmpty()) {
			int cur = qu.poll();

			if (cur == K)
				break;

			int a = cur + 1;
			int b = cur - 1;
			int c = cur * 2;

			if (0 <= a && a < 100001 && map[a] == 0) {
				qu.add(a);
				map[a] = map[cur]+1;
			}

			if (0 <= b && b < 100001 && map[b] == 0) {
				qu.add(b);
				map[b] = map[cur]+1;
			}

			if (0 <= c && c < 100001 && map[c] == 0) {
				qu.add(c);
				map[c] = map[cur]+1;
			}
		}
	}
}