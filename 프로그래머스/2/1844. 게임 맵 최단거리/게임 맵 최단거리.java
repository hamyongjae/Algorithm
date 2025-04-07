import java.util.*;

class Solution {
    
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited;
    static int row, col;
    
    public int solution(int[][] maps) {
        
        row = maps.length;
        col = maps[0].length;
        
        visited = new int[row][col];
        int answer = 0;
        
        BFS(0, 0, maps);
        
        if(visited[row - 1][col - 1] == 0)
            return -1;
        
        return visited[row - 1][col - 1];
    }
    
    public static void BFS(int y, int x, int[][] maps){
        Queue<int[]> qu = new LinkedList<>();
        
        qu.add(new int[]{y, x});
        
        visited[y][x] = 1;
        
        while(!qu.isEmpty()) {
            int cur_y = qu.peek()[0];
            int cur_x = qu.peek()[1];
            
            qu.poll();
            
            for(int i = 0; i < 4; i ++){
                int ny = cur_y + dy[i];
                int nx = cur_x + dx[i];
                
                if(ny < 0 || nx < 0 || row <= ny || col <= nx || visited[ny][nx] != 0)
                    continue;
                
                if(maps[ny][nx] == 1) {
                    qu.add(new int[]{ny, nx});
                    visited[ny][nx] = visited[cur_y][cur_x] + 1;
                }
            }
        }
    } 
}