class Solution {
    public int solution(int k, int[][] dungeons) {
        return DFS(0, k, dungeons, new boolean[dungeons.length]);
    }

    public int DFS(int dep, int k, int[][]dungeons, boolean[] visited) {
        if (dep == dungeons.length)
            return dep;
        int result = dep;

        for(int i=0; i<dungeons.length; i++) {
            if (visited[i] || k<dungeons[i][0])
                continue;

            visited[i] = true;
            result = Math.max(result, DFS(dep+1, k-dungeons[i][1], dungeons, visited));
            visited[i] = false;
        }
        return result;
    }
}