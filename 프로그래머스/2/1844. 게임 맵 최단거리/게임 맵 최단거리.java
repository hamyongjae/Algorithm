import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        
        int answer = 0;
        
        int Y = maps.length;
        int X = maps[0].length;
        
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        
        Queue<int[]> qu = new LinkedList<>();
        
        qu.add(new int[] {0, 0});
        
        while(!qu.isEmpty()){
            
            int y = qu.peek()[0];
            int x = qu.peek()[1];
            
            qu.poll();
            
            for(int i = 0; i < 4; i ++){
                
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(nx < 0 || ny < 0 || X <= nx || Y <= ny)
                    continue;
                
                if(maps[ny][nx] == 1){
                    
                    maps[ny][nx] = maps[y][x] + 1;
                    qu.add(new int[] {ny, nx});
                    
                }
            }
        }
        
        if(maps[Y-1][X-1] == 1){
            return -1;
        } else {
            return maps[Y-1][X-1];
        }
        
    }
}