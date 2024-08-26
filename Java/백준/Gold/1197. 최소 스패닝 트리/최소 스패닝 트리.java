//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edge> q = new PriorityQueue<>();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        for (int i = 1; i <= V; i++)
            parent[i] = i;

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A<B)
                q.add(new Edge(A, B, C));
            else
                q.add(new Edge(B, A, C));
        }

        int cnt = 0;
        long ans = 0;
        while (!q.isEmpty() && cnt < V-1) {
            Edge e = q.poll();

            if (!changeParent(e.A, e.B))
                continue;
            cnt++;
            ans += e.C;
        }
        System.out.println(ans);
    }

    public static int find(int n){
        if (parent[n] == n)
            return n;
        else
            return parent[n] = find(parent[n]);
    }

    public static boolean changeParent(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if (fa == fb)
            return false;

        parent[fb] = fa;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int A, B, C;

        public Edge(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public int compareTo(Edge o) {
            return this.C - o.C;
        }
    }
}