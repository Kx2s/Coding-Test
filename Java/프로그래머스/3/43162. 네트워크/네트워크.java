class Solution {
    int[][] arr;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int ans=0;
        arr = computers;
        visited = new boolean[n];

        for (int i=0; i<n; i++)
            if (!visited[i]){
                visited[i] = true;
                DFS(i);
                ans++;
            }

        return ans;
    }

    public void DFS(int num) {
        for (int i=0; i<arr.length; i++)
            if (arr[num][i] == 1 && !visited[i]){
                visited[i] = true;
                DFS(i);
            }
    }
}