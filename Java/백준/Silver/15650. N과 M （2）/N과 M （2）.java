import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i=1; i<=N-M+1; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }
        System.out.println(sb);
    }

    public static void dfs (int idx, int dep) {
        if (dep == M) {
            for (int i=1; i<=N; i++)
                if (visited[i])
                    sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = idx+1; i<=N; i++){
            visited[i] = true;
            dfs(i, dep+1);
            visited[i] = false;
        }
    }
}