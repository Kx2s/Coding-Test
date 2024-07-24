import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X, mx;
    static int[] ans;
    static ArrayList<Pair>[] arr;
    static ArrayList<Pair>[] reverse;
    static PriorityQueue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        mx = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        ans = new int[N+1];

        arr = new ArrayList[N+1];
        reverse = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[s].add(new Pair(e, t));
            reverse[e].add(new Pair(s, t));
        }

        extra(reverse);
        extra(arr);

        System.out.println(mx);
    }

    public static void extra(List<Pair>[] graph) {
        q = new PriorityQueue<>();
        q.offer(new Pair(X, 0));
        int cnt = 0;
        boolean[] visited = new boolean[N+1];

        while (!q.isEmpty() && cnt < N) {
            Pair p = q.poll();

            if (visited[p.to])
                continue;
            visited[p.to] = true;
            cnt++;
            ans[p.to] += p.time;
            mx = Math.max(mx, ans[p.to]);

            for (Pair g : graph[p.to]){
                if (g.to == X || visited[g.to])
                    continue;
                q.offer(new Pair(g.to, p.time + g.time));
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int to, time;

        public Pair(int to, int time) {
            this.to = to;
            this.time = time;
        }
        @Override
        public int compareTo(Pair o) {
            return time - o.time;
        }
    }
}