package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

// BOJ_1021번
// 회전하는 큐
public class BOJ_1021 {

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int target;
		int idx=1;
		int cnt =0;
		Deque<Integer> dq = new ArrayDeque<Integer>();

		for (int i = 0; i < N; i++)
			dq.add(i + 1);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			target = Integer.parseInt(st.nextToken());
			idx = 1;
			Iterator<Integer> it = dq.iterator();
			while (it.hasNext()) {
				if (it.next() == target)
					break;
				idx++;
			}
			
			int front = idx - 1;
			int back =  dq.size() +1 -idx;
			
			if(front < back)
			{
				for(int j =0; j<front; j++) {
					dq.addLast(dq.pollFirst());
					cnt++;
				}
				dq.pollFirst();
			}
			else 
			{
				for(int j=0; j<back; j++) {
					dq.addFirst(dq.pollLast());
					cnt++;
				}
				dq.pollFirst();
			}
		}
		System.out.println(cnt);
	}
}
