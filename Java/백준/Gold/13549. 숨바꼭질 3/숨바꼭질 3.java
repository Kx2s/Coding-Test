//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(BFS(N, K));
    }

    public static int BFS (int N, int K){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        boolean[] visited = new boolean[200000];
        q.offer(new Pair(N, 0));

        while (!q.isEmpty()){
            Pair p = q.poll();

            if (visited[p.x])
                continue;
            visited[p.x] = true;

            if (p.x == K)
                return p.time;
            else if (p.x < K){
                q.offer(new Pair(p.x+1, p.time+1));
                q.offer(new Pair(p.x*2, p.time));
            }
            if (p.x != 0)
                q.offer(new Pair(p.x-1, p.time+1));
        }
        return 0;
    }

    static class Pair implements Comparable<Pair>{
        int x, time;

        public Pair(int x, int time){
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Pair o){
            return this.time - o.time;
        }
    }
}