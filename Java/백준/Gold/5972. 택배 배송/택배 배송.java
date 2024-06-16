import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] ans;
    static List<Pair>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[N+1];
        Arrays.fill(ans, 50000*1000+1);
        graph = new List[N+1];

        for (int i=0; i<=N; i++)
            graph[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Pair(B, C));
            graph[B].add(new Pair(A, C));
        }

        bfs(1);
        System.out.println(ans[N]);
    }

    public static void bfs(int n) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(n, 0));
        while(!q.isEmpty()){
            Pair poll = q.poll();

            if (ans[poll.to] < poll.cost)
                continue;

            for (Pair p : graph[poll.to]) {
                int tmp = poll.cost + p.cost;
                if (ans[p.to] > tmp) {
                    ans[p.to] = tmp;
                    if (p.to != N)
                        q.add(new Pair(p.to, tmp));
                }
            }
        }
    }
    public static class Pair implements Comparable<Pair>{
        int to;
        int cost;

        public Pair (int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            return cost - o.cost;
        }
    }
}