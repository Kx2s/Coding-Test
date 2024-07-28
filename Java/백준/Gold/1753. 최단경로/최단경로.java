import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<Pair>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine())-1;
        arr = new List[V];
        for (int i=0; i<V; i++)
            arr[i] = new ArrayList<Pair>();


        for (int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            arr[u].add(new Pair (v, w));
        }

        int[] ans = extra();

        for (int i=0; i<V; i++)
            if (i == K)
                sb.append(0).append("\n");
            else
                sb.append(ans[i]!=0? ans[i] : "INF").append("\n");
        System.out.println(sb);
    }

    public static int[] extra (){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int[] result = new int[V];
        int cnt = 0;

        q.offer(new Pair(K,0));

        while (!q.isEmpty() && cnt < V) {
            Pair p = q.poll();
            if (result[p.now] != 0)
                continue;
            result[p.now] = p.w;
            cnt++;

            for (Pair a : arr[p.now])
                if (K != a.now && result[a.now] == 0)
                    q.offer(new Pair(a.now, p.w + a.w));
        }
        return result;
    }

    static class Pair implements Comparable<Pair> {
        int now;
        int w;

        Pair(int now, int w) {
            this.now = now;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return w - o.w;
        }
    }
}