//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Bus>[] Buses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Buses = new List[N+1];
        for (int i=0; i<=N; i++)
            Buses[i] = new ArrayList();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Buses[a].add(new Bus(b, cost));
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(BFS(A, B));
    }

    public static int BFS(int A, int B){
        PriorityQueue<Bus> q = new PriorityQueue<>();
        q.offer(new Bus(A, 0));
        boolean[] visited = new boolean[N+1];

        while (!q.isEmpty()){
            Bus b = q.poll();

            if (b.to == B)
                return b.cost;

            if (visited[b.to])
                continue;
            visited[b.to] = true;

            for (Bus i : Buses[b.to]){
                if (visited[i.to])
                    continue;

                q.offer(new Bus(i.to, b.cost + i.cost));
            }
        }
        return -1;
    }

    static class Bus implements Comparable<Bus> {
        int to;
        int cost;

        public Bus(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus b) {
            if (this.cost == b.cost)
                return b.to - this.to;
            return this.cost - b.cost;
        }
    }
}