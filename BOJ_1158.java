package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_1158. 조세퍼스 문제
public class BOJ_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("<");
		Queue<Integer> qu = new LinkedList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int idx = 1;

		for (int i = 1; i <= N; i++)
			qu.add(i);

		while (qu.size() > 0) {
			if (idx % M != 0)
				qu.add(qu.remove());
			else {
				if (qu.size() > 1)
					sb.append(qu.remove() + ", ");
				else
					sb.append(qu.remove());
			}
			idx++;
		}
		sb.append(">");
		
		System.out.println(sb);
	}

}
