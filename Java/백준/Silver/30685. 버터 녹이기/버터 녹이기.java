//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Butter> q = new PriorityQueue<>();
        int ans = Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            q.offer(new Butter(x, (h-1)/2));
        }

        Butter B1 = q.poll();
        while (!q.isEmpty()) {
            Butter B2 = q.poll();
            int x = B2.x - B1.x -1;
            if (x < B1.h + B2.h) {
                int min = Math.min(B1.h, B2.h);
                if (x > min * 2){
                    x -= min * 2;
                    ans = Math.min(ans, x+min);
                }
                else
                    ans = Math.min(ans, x/2);
            }
            B1 = B2;
        }
        System.out.println(ans != Integer.MAX_VALUE ? ans : "forever");
    }

    static class Butter implements Comparable<Butter> {
        int x, h;

        Butter(int x, int h) {
            this.x = x;
            this.h = h;
        }

        public int compareTo(Butter o) {
            return this.x - o.x;
        }
    }
}