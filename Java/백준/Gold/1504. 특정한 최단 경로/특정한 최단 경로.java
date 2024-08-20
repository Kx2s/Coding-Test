//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static List<Pair>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for (int i=1; i<=N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Pair(b, c));
            graph[b].add(new Pair(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] arr1 = bfs(v1);
        int[] arr2 = bfs(v2);

        if ((arr1[1]==-1 || arr2[N]==-1) && (arr1[N]==-1 || arr2[1]==-1))
            System.out.println(-1);
        else if (arr1[1]==-1 || arr2[N]==-1)
            System.out.println(arr1[N]+arr2[1]+arr1[v2]);
        else if (arr1[N]==-1 || arr2[1]==-1)
            System.out.println(arr1[1]+arr2[N]+arr1[v2]);
        else
            System.out.println(Math.min(arr1[1]+arr2[N], arr1[N]+arr2[1])+arr1[v2]);
    }

    public static int[] bfs (int idx){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int[] result = new int[N+1];
        Arrays.fill(result, -1);
        result[idx] = 0;

        for (Pair p : graph[idx])
            q.add(p);

        while (!q.isEmpty()){
            Pair p = q.poll();

            if (result[p.to] != -1)
                continue;
            result[p.to] = p.dis;

            for (Pair pp : graph[p.to]){
                if (result[pp.to] == -1){
                    q.add(new Pair(pp.to, p.dis + pp.dis));
                }
            }
        }
        return result;
    }

    static class Pair implements Comparable<Pair> {
        int to, dis;

        public Pair(int to, int dis) {
            this.to = to;
            this.dis = dis;
        }

        @Override
        public int compareTo(Pair o) {
            return dis - o.dis;
        }
    }
}