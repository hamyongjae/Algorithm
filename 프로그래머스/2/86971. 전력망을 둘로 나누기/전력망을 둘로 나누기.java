import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> al;
    static int cnt = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        al = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            al.add(new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            al.get(a).add(b);
            al.get(b).add(a);
        }
        
        for(int i = 0; i < wires.length; i++){
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            boolean[] visited = new boolean[n + 1];
            
            visited[b] = true;
            
            cnt = 0;
            
            DFS(a, visited);
            
//             System.out.println("i = " + i + " cnt = " + cnt);
//             System.out.println("노드 차이 개수 : " + (n - cnt - cnt));
//             System.out.println();
            
            // | 나눠진 두 전력망 송전탑 개수 차이 |
            // = |서브트리 크기 - 나머지 크기|
            // = |서브트리 크기 - (전체 노드 수 - 서브트리 크기)|
            // = |전체 노드 수 - 서브트리 크기 - 서브트리 크기|
            answer = Math.min(answer, Math.abs(n - cnt - cnt));
            
        }
        
        return answer;
    }
    
    public void DFS(int V, boolean[] visited) {
        
        visited[V] = true;
        System.out.println("방문 : " + V);
        cnt++;

        for(int i = 0; i < al.get(V).size(); i++){
            int next_v = al.get(V).get(i);
            
            if(!visited[next_v]){
                DFS(next_v, visited);
            }
        }
    }
}