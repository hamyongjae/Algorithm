package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_16433
// 주디와 당근농장
// BFS
public class BOJ_16433 {

	static int N, R, C;
	static char map[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				map[i][j] = '0';
		}
		
		map[R][C]='v';
		BFS(new Point_16433(R,C));

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}

	public static void BFS(Point_16433 p) {
		Queue<Point_16433> q = new LinkedList<Point_16433>();
		char c = 0;
		
		q.add(p);
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			
			q.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = x+ dx[i];
				int ny = y+ dy[i];
				
				if(nx < 1 || N < nx || ny < 1 || N < ny) continue;
				if(map[ny][nx]=='0'){
					q.add(new Point_16433(ny,nx));
					
					if(map[y][x]=='v') c='.'; 
					else if(map[y][x]=='.') c='v';
					
					map[ny][nx]=c;
				}
			}
		}
		
	}
}

class Point_16433 {
	int x, y;

	public Point_16433(int y, int x) {
		this.x = x;
		this.y = y;
	}
}