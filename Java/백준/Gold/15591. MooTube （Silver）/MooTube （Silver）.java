//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static List<Pair>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new Pair(q,r));
            graph[q].add(new Pair(p,r));
        }

        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(BFS(k, v)).append("\n");
        }
        System.out.println(sb);
    }

    public static int BFS(int k, int v){
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int result = 0;
        q.add(new Pair(v, 1000000000));
        visited[v] = true;

        while (!q.isEmpty()){
            Pair p = q.poll();

            for(Pair g : graph[p.to]){
                if (!visited[g.to]){
                    visited[g.to] = true;

                    int mn = Math.min(g.min, p.min);
                    if (k <= mn){
                        result++;
                        q.add(new Pair(g.to, mn));
                    }
                }
            }
        }
        return result;
    }

    static class Pair {
        int to, min;

        public Pair(int to, int min) {
            this.to = to;
            this.min = min;
        }
    }
}