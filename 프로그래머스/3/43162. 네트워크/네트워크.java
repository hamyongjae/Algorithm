class Solution {

    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, int cur) {
        visited[cur] = true;

        for (int next = 0; next < computers.length; next++) {
            if (!visited[next] && computers[cur][next] == 1) {
                dfs(computers, next);
            }
        }
    }
}
