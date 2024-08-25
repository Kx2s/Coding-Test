//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Game> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            q.add(new Game(idx, c, h));
        }

        for (int i=0; i < K; i++)
            sb.append(q.poll().i).append("\n");
        System.out.println(sb);
    }

    static class Game implements Comparable<Game> {
        int i, c, h;

        public Game(int i, int c, int h) {
            this.i = i;
            this.c = c;
            this.h = h;
        }

        public int compareTo(Game o) {
            long cost1 = (long) this.h *o.c;
            long cost2 = (long) o.h *this.c;

            if (cost1 == cost2) {
                if (this.c == o.c)
                    return this.i - o.i;
                return this.c - o.c;
            }
            return cost1<cost2? 1:-1 ;
        }
    }
}