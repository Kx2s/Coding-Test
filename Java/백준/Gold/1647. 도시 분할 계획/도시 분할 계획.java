//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Road> q = new PriorityQueue<>();
        int ans = 0;
        int cnt = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 0; i <= N; i++)
            parent[i] = i;

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A < B)
                q.offer(new Road(A, B, C));
            else
                q.offer(new Road(B, A, C));
        }

        while (!q.isEmpty() && cnt < N-2) {
            Road r = q.poll();
            if (!union(r.A, r.B))
                continue;

            ans += r.C;
            cnt++;
        }
        System.out.println(ans);
    }

    public static int find(int n) {
        if (parent[n] == n)
            return n;
        else
            return parent[n] = find(parent[n]);
    }

    public static boolean union (int a, int b){
        int fa = find(a);
        int fb = find(b);

        if (fa == fb)
            return false;

        parent[fb] = fa;
        return true;
    }


    static class Road implements Comparable<Road> {
        int A, B, C;

        public Road(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public int compareTo(Road o) {
            return this.C - o.C;
        }
    }
}