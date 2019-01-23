package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice {
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N;
	static int M;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		visited= new boolean[N][M];
		arr = new int[N][M];
		
		for(int i=0; i<N; i++){
			String str = sc.nextLine();
			for(int j =0; j<M; j++){
				arr[i][j]=str.charAt(j)-'0';
				visited[i][j]=false;
			}
		}
		visited[0][0]=true;
	}
	
	static public void BFS(int x, int y) {
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nextX = p.x+dx[i];
				int nextY = p.y+dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				
				if(visited[nextX][nextY] || arr[nextX][nextY]==0) {
					continue;
				}
				
				q.add(e)
			}
			
			
		}
	} 
}

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
