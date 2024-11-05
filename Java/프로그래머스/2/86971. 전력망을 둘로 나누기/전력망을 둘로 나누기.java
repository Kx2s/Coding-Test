import java.util.*;

class Solution {
    List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        graph = new List[n+1];
        for (int i = 1; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        for (int[] w : wires){
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }

        int ans = n;
        boolean[] visited;
        for (int[] w : wires) {
            visited = new boolean[n+1];
            graph[w[0]].remove((Integer) w[1]);
            graph[w[1]].remove((Integer) w[0]);

            ans = Math.min(ans, Math.abs(check(w[0], visited) - check(w[1], visited)));

            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }

        return ans;
    }

    public int check (int idx, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        if (!visited[idx]) {
            q.offer(idx);
            visited[idx] = true;
        }

        int result = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            result++;

            for (int g : graph[now]){
                if (!visited[g]){
                    visited[g] = true;
                    q.offer(g);
                }
            }
        }
        return result;
    }
}