import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> ladder;
    static Map<Integer, Integer> snakes;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ladder = new HashMap<>();
        snakes = new HashMap<>();

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        PriorityQueue<Pair> q = new PriorityQueue();
        q.offer(new Pair(1, 0));
        int[] min = new int[107];
        boolean[] visited = new boolean[107];

        while (!q.isEmpty()){
            Pair p = q.poll();
            if (p.i >= 100)
                return p.n;

            if (visited[p.i])
                continue;

            while (true) {
                visited[p.i] = true;
                if (snakes.containsKey(p.i))
                    p.i = snakes.get(p.i);
                else if (ladder.containsKey(p.i))
                    p.i = ladder.get(p.i);
                else
                    break;
            }

            for (int i=1; i<=6; i++) {
                if (min[p.i+i] == 0 || min[p.i+i] > p.n+1) {
                    min[p.i+i] = p.n+1;
                    q.offer(new Pair(p.i+i, p.n+1));
                }
            }
        }
        return 0;
    }

    static class Pair implements Comparable<Pair> {
        int i;
        int n;

        Pair(int i, int n) {
            this.i = i;
            this.n = n;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.n == o.n)
                return o.i - this.i;
            return this.n - o.n;
        }
    }
}