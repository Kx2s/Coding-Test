import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visit;
    static boolean[][] Graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        Graph = new boolean[N+1][N+1];


        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Graph[a][b] = true;
            Graph[b][a] = true;
        }
        for (int i = 1; i<=N; i++) {
            if (!visit[i]) {
                bfs(i);
                ans++;
            }
        }
        System.out.print(ans);
    }
    public static void bfs(int a){
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int i = 1; i<=N; i++) {
                if (Graph[idx][i] && !visit[i]){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}